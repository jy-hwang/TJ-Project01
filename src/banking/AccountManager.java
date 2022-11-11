package banking;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import commonUtil.CommonUtil;
import friendInfo.HighFriend;
import friendInfo.UnivFriend;
import main.ICustomDefine;

public class AccountManager {
    // 컨트롤 클래스로 프로그램의 전반적인 기능 구현하기

    // 멤버변수
    private HashSet<Account> accHashSet;

    // 생성자
    public AccountManager() {
        accHashSet = new HashSet<>();
    }


    // 메뉴보기
    void showMenu() {
        System.out.println("========================= 계 좌 관 리 =================================");
        System.out.printf("1. 계좌개설 \t 2. 입금 \t 3. 출금 \t 4. 계좌정보출력 %n");
        System.out.printf("5. 저장옵션\t 6. 이름수정 \t 7. 계좌간이체 \t 8. 상위메뉴로 %n");
        System.out.println("=======================================================================");
    }

    // 계좌만들기
    void makeAccount() {
        String accNo, name, creditRating;
        int balance, interest;

        int accountKind = CommonUtil.scanInt("1.보통계좌 \t 2.신용신뢰계좌");

        accNo = CommonUtil.scanValue("계좌번호");
        name = CommonUtil.scanValue("이름");
        balance = CommonUtil.scanInt("최초잔고");
        interest = CommonUtil.scanInt("기본이자%(정수형태)");

        Account acc = null;

        if (accountKind == ICustomDefine.NORMAL_ACCOUNT) {
            acc = new NormalAccount(accNo, name, balance, interest);
        } else if (accountKind == ICustomDefine.HIGH_CREDIT_ACCOUNT) {
            creditRating = CommonUtil.scanValue("신용등급(A,B,C 중)");
            acc = new HighCreditAccount(accNo, name, balance, interest, creditRating);
        }

        boolean isDup = accHashSet.add(acc);

        if (isDup == false) {
            System.out.println("중복된 계좌를 발견했습니다.");
            String dupYn = CommonUtil.scanValue("덮어쓰려면 Y, 취소하려면 N");

            if ("Y".equalsIgnoreCase(dupYn)) {
                accHashSet.remove(acc);
                accHashSet.add(acc);
                System.out.println("덮어썼습니다.");
            } else if ("N".equalsIgnoreCase(dupYn)) {
                System.out.println("취소되었습니다.");
                return;
            }
        }
        System.out.println("=======================================================================");
        System.out.println("개설된 계좌정보는 다음과 같습니다.");
        System.out.println(acc.toString());
        System.out.println("=======================================================================");
    }

    // 입금하기
    void depositMoney() {

        System.out.println("계좌번호와 입금액을 입력하세요.");
        String accNo = CommonUtil.scanValue("계좌번호");

        int money = CommonUtil.scanInt("입금액");
        if (money % 500 != 0) {
            System.out.println("입금은 500원 단위로 가능합니다.");
            return;
        }

        if (money <= 499) {
            System.out.println("입금은 500원 이상부터 가능합니다.");
            return;
        }

        int count = 0, balance = 0;
        for (Account ac : accHashSet) {
            if (accNo.equals(ac.getAccountNo())) {
                ac.setBalance(ICustomDefine.DEPOSIT, money);
                balance = ac.getBalance();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("일치하는 계좌가 없어 입금하지 못했습니다.");
        } else {
            System.out.println("입금완료되었습니다. 입급 후 잔액은 " + balance + " 원 입니다.");
        }
    }

    // 출금하기
    void withdrawMoney() {
        System.out.println("계좌번호와 출금액을 입력하세요.");
        String accNo = CommonUtil.scanValue("계좌번호");

        int money = CommonUtil.scanInt("출금액");
        if (money % 1000 != 0) {
            System.out.println("출금은 1000원 단위로 가능합니다.");
            return;
        }

        if (money < 1000) {
            System.out.println("출금은 1000원 이상가능합니다.");
            return;
        }

        int count = 0, balance = 0;
        for (Account ac : accHashSet) {
            if (accNo.equals(ac.getAccountNo())) {
                ac.setBalance(ICustomDefine.WITHDRAW, money);
                balance = ac.getBalance();
                count++;
            }
        }

        if (count == 0) {
            System.out.println("일치하는 계좌가 없어 출금하지 못했습니다.");
        } else {
            System.out.println("출금완료되었습니다. 출금 후 잔액은 " + balance + " 원 입니다.");
        }

    }

    // 계좌정보보기
    void showAccInfo() {
        System.out.println("========================= 계 좌 조 회 =================================");
        for (Account ac : accHashSet) {
            ac.showAccountInfo();
        }
    }

    // 계좌 정보 수정
    void modifyName() {
        System.out.println("========================= 정 보 수 정 =================================");
        String tmpNo = CommonUtil.scanValue("수정할 계좌번호");

        String beforeName = "";
        String afterName = "";
        int count = 0;
        for (Account ac : accHashSet) {
            if (tmpNo.equals(ac.getAccountNo())) {
                beforeName = ac.getName();
                System.out.printf("변경 전 이름 : %s\t", beforeName);
                afterName = CommonUtil.scanValue("수정할 이름");
                if (!afterName.isEmpty()) {
                    ac.setName(afterName);
                    count++;
                } else {
                    afterName = beforeName;
                }

                if (ac instanceof NormalAccount) {
                    int tempRate = CommonUtil.scanInt("변경할 이자");
                    if (tempRate > 0) {
                        ((NormalAccount) ac).setInterest(tempRate);
                        count++;
                    }
                } else if (ac instanceof HighCreditAccount) {
                    int tempRate = CommonUtil.scanInt("변경할 이자");
                    if (tempRate > 0) {
                        ((HighCreditAccount) ac).setInterest(tempRate);
                        count++;
                    }
                    String tmpStr = CommonUtil.scanValue("신용등급");
                    if (!tmpStr.isEmpty()) {
                        ((HighCreditAccount) ac).setCreditRating(tmpStr);
                        count++;
                    }
                }
            }
        }
        if (0 == count) {
            System.out.println("계좌번호가 없거나 정보가 변경되지 않았습니다.");
        } else {
            System.out.println("정보가 변경되었습니다.");
        }
    }

    // 이체처리
    /*
     * 처리로직
     * 1. 출금할 계좌와 이체할 금액, 입금할 계좌 입력받기
     * 2. 출금할 계좌가 있는지와 그 계좌의 잔고가 이체할 금액보다 적은지 확인
     * 3. 입금할 계좌가 있는지 확인
     * 4. 앞의 2,3 조건을 모두 만족할 경우 출금할 계좌에서 출금진행, 입금할 계좌에서 입금 진행후 이체완료 메시지 출력
     * 5. 아닌 경우 왜 안되었는지에 대한 오류 메시지 출력.
     */
    void transfer() {
        System.out.println("======================== 계 좌 간 이 체 ================================");
        String withdrawNo = CommonUtil.scanValue("출금할 계좌번호");
        int transferMoney = CommonUtil.scanInt("이체할금액");
        String depositNo = CommonUtil.scanValue("입금할 계좌번호");
        boolean isFind1 = false, isFind2 = false;

        for (Account ac : accHashSet) {
            // System.out.println(withdrawNo.equals(ac.getAccountNo()));
            if (withdrawNo.equals(ac.getAccountNo()) && (transferMoney <= ac.getBalance())) {
                isFind1 = true;
                break;
            }
        }

        if (isFind1) {
            System.out.println("출금할 계좌를 찾고 이체할 금액이 출금할 계좌의 잔고보다 적거나 같습니다.");
        } else {
            System.out.println("출금할 계좌가 없거나 이체할 금액이 출금할 계좌의 잔고보다 큽니다.");
        }

        for (Account ac : accHashSet) {
            if (depositNo.equals(ac.getAccountNo())) {
                isFind2 = true;
            }
        }

        if (isFind2) {
            System.out.println("입금할 계좌를 찾았습니다.");
        } else {
            System.out.println("입금할 계좌를 찾을 수 없습니다.");
        }
        if (isFind1 && isFind2) {
            for (Account ac : accHashSet) {
                if (withdrawNo.equals(ac.getAccountNo())) {
                    ac.setBalance(ICustomDefine.WITHDRAW, transferMoney);
                }
            }

            for (Account ac : accHashSet) {
                if (depositNo.equals(ac.getAccountNo())) {
                    ac.setBalance(ICustomDefine.DEPOSIT, transferMoney);
                }
            }
            System.out.println("이체되었습니다.");
        } else {
            System.out.println("이체실패했습니다.");
            return;
        }
    }

    // 저장옵션
    void saveOption(AutoSaver auto) {
        System.out.println("=================== 저 장 옵 션 =========================");
        System.out.printf("1. 자동저장 On \t 2. 자동저장 Off%n");

        int temp = CommonUtil.scanInt("저장옵션을 ");

        switch (temp) {
            case ICustomDefine.AUTOSAVE_ON:
                if (auto.isAlive()) {
                    System.out.println("실행중입니다.");
                    break;
                } else {
                    auto.setDaemon(true);
                    auto.start();
                    break;
                }
            case ICustomDefine.AUTOSAVE_OFF:
                System.out.println("자동저장 옵션 Off");
                auto.interrupt();
                break;
        }
    }

    // 중간 상태 저장하기
    void autoSave() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("src/saveFile/AutuSaveAccount.txt"));
            for (Account a : accHashSet) {
                pw.write(a.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();

        }
    }

    // 저장하기
    void saveAccountInfo() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/saveFile/AccountInfo.obj"));

            for (Account a : accHashSet) {
                // 파일에 저장한다
                out.writeObject(a);
            }
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다.");
        }
        System.out.println("계좌 정보가 저장되었습니다.");
    }


    // 불러오기
    void loadAccountInfo() {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new FileInputStream("src/saveFile/AccountInfo.obj"));

            while (true) {
                accHashSet.add((Account) in.readObject());
            }

        } catch (FileNotFoundException e) {
            System.out.println("불러올 파일이 없습니다.");
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다.");
        } catch (EOFException e) {
            System.out.println("파일의 끝까지 불러왔습니다.");
        } catch (IOException e) {
            System.out.println("입출력오류가 발생했습니다.");
        }

        System.out.println("계좌 정보가 복원되었습니다.");
    }

}
