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
import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {

    // 컨트롤 클래스로 프로그램의 전반적인 기능 구현하기
    private HashSet<Account> accHashSet;

    public AccountManager() {
        accHashSet = new HashSet<>();
    }

    void showMenu() {
        System.out.println("========================= 계 좌 관 리 =================================");
        System.out.printf("1. 계좌개설 \t 2. 입금 \t 3. 출금 \t 4. 계좌정보출력 %n");
        System.out.printf("5. 저장옵션\t 6. 이름수정 \t 7. 계좌간이체 \t 8. 상위메뉴로 %n");
        System.out.println("=======================================================================");
    }

    // 계좌만들기
    void makeAccount() {
        System.out.println("학원에서 작업완료");
        System.out.println("**신규계좌개설**");
        String accNo, name, creditRating;
        int balance, interest;

        int accountKind = scanInt("1.보통계좌 \t 2.신용신뢰계좌");

        accNo = scanValue("계좌번호");
        name = scanValue("이름");
        balance = scanInt("최초잔고");
        interest = scanInt("기본이자%(정수형태)");

        Account acc = null;

        if (accountKind == 1) {
            acc = new NormalAccount(accNo, name, balance, interest);
            // accHashSet.add(acc);
        } else {
            creditRating = scanValue("신용등급(A,B,C 중)");
            acc = new HighCreditAccount(accNo, name, balance, interest, creditRating);
            // accArray[numOfAccount++] = hiCreAcc;
        }

        boolean isDup = accHashSet.add(acc);

        if (isDup == false) {
            System.out.println("중복된 계좌를 발견했습니다.");
            String dupYn = scanValue("덮어쓰려면 Y, 취소하려면 N");

            if ("Y".equalsIgnoreCase(dupYn)) {
                accHashSet.remove(acc);
                accHashSet.add(acc);
                System.out.println("덮어썼습니다.");
            } else if ("N".equalsIgnoreCase(dupYn)) {
                System.out.println("취소되었습니다.");
                return;
            }
        }
    }

    // 입금하기
    void depositMoney() {
        
        System.out.println("계좌번호와 입금액을 입력하세요.");
        String accNo = scanValue("계좌번호");
        
        int money = scanInt("입금액");
        if (money % 500 != 0) {
            System.out.println("입금은 500원 단위로 가능합니다.");
            return;
        }
       
        int count = 0;
        for (Account ac : accHashSet) {
            if (accNo.equals(ac.getAccountNo())) {
                ac.setBalance(ICustomDefine.DEPOSIT, money);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("일치하는 계좌가 없어 입금하지 못했습니다.");
        }
    }

    // 출금하기
    void withdrawMoney() {
        System.out.println("계좌번호와 출금액을 입력하세요.");
        String accNo = scanValue("계좌번호");
       
        int money = scanInt("출금액");
        if (money % 1000 != 0) {
            System.out.println("출금은 1000원 단위로 가능합니다.");
            return;
        }
        
        int count = 0;
        for (Account ac : accHashSet) {
            if (accNo.equals(ac.getAccountNo())) {
                ac.setBalance(ICustomDefine.WITHDRAW, money);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("일치하는 계좌가 없어 출금하지 못했습니다.");
        }

    }

    // 계좌정보보기
    void showAccInfo() {
        System.out.println("계좌정보를 조회합니다.");
        /*for (int i = 0; i < numOfAccount; i++) {
            accArray[i].showAccountInfo();
        }*/
        for (Account ac : accHashSet) {
            ac.showAccountInfo();
        }
    }

    // 계좌 이름 수정
    void modifyName() {
        System.out.println("=======이름수정========");
        String tmpNo = scanValue("수정할 계좌번호");
        String tmpName = scanValue("수정할 이름");

        for (Account ac : accHashSet) {
            if (tmpNo.equals(ac.getAccountNo())) {
                ac.setName(tmpName);
            }
        }
        System.out.println("=======수정완료========");
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
        System.out.println("=======계좌간이체========");
        String withdrawNo = scanValue("출금할 계좌번호");
        int transferMoney = scanInt("이체할금액");
        String depositNo = scanValue("입금할 계좌번호");
        boolean isFind1 = false, isFind2 = false;

        for (Account ac : accHashSet) {
            System.out.println(withdrawNo.equals(ac.getAccountNo()));
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

        }
        // ac.setBalance(ICustomDefine.DEPOSIT, transferMoney);
        System.out.println("=======이체완료========");


    }

    // 저장옵션
    void saveOption(AutoSaver auto) {

        System.out.println("스레드 상태 :: "+auto.getState());
        System.out.println("=======저장옵션========");
        System.out.printf("1. 자동저장 On \t 2. 자동저장 Off%n");

        int temp = scanInt("저장옵션을 ");

        // AutoSaver as = new AutoSaver();

        switch (temp) {
            case 1:
                if (auto.isAlive()) {
                    System.out.println("실행중입니다.");
                    break;
                } else {
                    auto.setDaemon(true);
                    auto.start();
                    break;
                }
            case 2:
                System.out.println("자동저장 옵션 Off");
                // as.setDaemon(false);
                // Thread.State
                auto.interrupt();
                //auto.stop();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            pw.close();

        }

    }



    // 저장하기
    void saveAccountInfo() {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream("src/saveFile/AccountInfo.obj"));

            for (Account a : accHashSet) {
                // 파일에 저장한다 , 즉 직렬화한다.
                out.writeObject(a);
            }
            // out.writeObject(accHashSet);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
                // stuHs.add((Student)ois.readObject());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            System.out.println("파일 끝");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("계좌 정보가 복원되었습니다.");
    }


    static public String scanValue(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + "을(를) 입력>>");
        String inputStr = "";
        try {
            inputStr = scan.nextLine();
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        return inputStr;
    }

    static public int scanInt(String title) {
        Scanner scan = new Scanner(System.in);
        System.out.print(title + "을(를) 입력>>");
        int inputInt = 1;
        try {
            inputInt = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("정수를 입력하세요.");
        }
        return inputInt;
    }


}
