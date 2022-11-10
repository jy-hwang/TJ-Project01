package banking;

import main.ICustomDefine;

public class HighCreditAccount extends Account {

    String creditRating;
    int interest;

    public HighCreditAccount(String accountNo, String name, int balance, int interest, String creditString) {
        super(accountNo, name, balance);
        this.creditRating = (creditString.toUpperCase());
        this.interest = interest;
    }

    @Override
    public void setBalance(int tempNum, int money) {
        if (tempNum == ICustomDefine.DEPOSIT) {
            // 신용계좌 : 잔고 + (잔고 * 기본이자 ) + (잔고 * 추가이자) + 입금액
            if ("A".equalsIgnoreCase(creditRating)) {
                int tempMoney = (super.getBalance() * interest / 100) + (super.getBalance() * ICustomDefine.A_RATE / 100) + money;
                super.setBalance(ICustomDefine.DEPOSIT, tempMoney);
            } else if ("B".equalsIgnoreCase(creditRating)) {
                int tempMoney = (super.getBalance() * interest / 100) + (super.getBalance() * ICustomDefine.B_RATE / 100) + money;
                super.setBalance(ICustomDefine.DEPOSIT, tempMoney);
            } else if ("C".equalsIgnoreCase(creditRating)) {
                int tempMoney = (super.getBalance() * interest / 100) + (super.getBalance() * ICustomDefine.C_RATE / 100) + money;
                super.setBalance(ICustomDefine.DEPOSIT, tempMoney);
            } else {
                int tempMoney = (super.getBalance() * interest / 100) + money;
                super.setBalance(ICustomDefine.DEPOSIT, tempMoney);
            }

        } else {
            super.setBalance(ICustomDefine.WITHDRAW, money);

        }
    }

    @Override
    void showAccountInfo() {
        super.showAccountInfo();
        System.out.printf(" 기본이자 : %d\t 신용등급 : %s%n ", this.interest, this.creditRating);
    }

    @Override
    public String toString() {
        return "HighCreditAccount \t [계좌번호 = " + getAccountNo() + "\t, 이름 = " + getName() + "\t, 현재 잔고 = " + getBalance() + "\t, 기본이자 = " + interest + "\t, 신용등급  = " + creditRating + "]\n";
    }


}
