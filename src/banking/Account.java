package banking;

import java.io.Serializable;
import java.util.Objects;
import commonUtil.CommonUtil;
import main.ICustomDefine;

abstract public class Account implements Serializable {

    // 계좌정보를 표현한 부모 클래스

    // 멤버변수
    private String accountNo;
    private String name;
    private int balance;

    // 생성자
    public Account(String accountNo, String name, int balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    // getter / setter
    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int tempNum, int money) {
        if (tempNum == ICustomDefine.DEPOSIT) {
            System.out.print(money + "원 입금합니다.");
            this.balance += money;
        } else if (tempNum == ICustomDefine.WITHDRAW) {
            if (money > balance) {
                String allWithdraw = CommonUtil.scanValue("잔고가 부족합니다. 금액전체를 출금할까요?(Y/N)");
                if ("Y".equalsIgnoreCase(allWithdraw)) {
                    System.out.printf("금액 전체 " + this.balance + "원 출금합니다.\t\n");
                    this.balance = 0;
                } else if ("N".equalsIgnoreCase(allWithdraw)) {
                    System.out.println("출금처리 취소되었습니다.");
                    return;
                }else{
                    System.out.println("잘못된 입력입니다.");
                    return;
                }
            } else {
                System.out.print(money + "원 출금합니다.\t");
                this.balance -= money;
                System.out.println("출금완료되었습니다. 출금 후 잔액은 " + this.balance + " 원 입니다.");
            }
        }
    }

    void showAccountInfo() {
        System.out.printf("계좌번호 : %s  \t이름 : %s  \t잔액 : %d\t", accountNo, name, balance);
    }



    @Override
    public String toString() {
        return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance + "]";
    }

    @Override
    public int hashCode() {
        int returnCode1 = Objects.hash(this.getAccountNo());
        return returnCode1;
    }


    @Override
    public boolean equals(Object obj) {
        Account ac = (Account) obj;
        if (ac.getAccountNo().equals(this.getAccountNo())) {
            return true;
        } else {
            return false;
        }
    }
}
