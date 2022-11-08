package banking;

import java.util.Objects;

public class NormalAccount extends Account{

    int interest;
    
    public NormalAccount(String accountNo, String name, int balance, int interest) {
        super(accountNo, name, balance);
        this.interest = interest;
    }
    
    @Override
    public void setBalance(int tempNum, int money) {
        //super.setBalance(tempNum, money);
        if(tempNum == ICustomDefine.DEPOSIT){
                int tempMoney = (super.getBalance() * interest / 100) + money;
                super.setBalance(ICustomDefine.DEPOSIT,tempMoney);
        }else{
                super.setBalance(ICustomDefine.WITHDRAW,money);
        }
    }
    
    @Override
    void showAccountInfo() {
     super.showAccountInfo();
     System.out.printf(" 기본이자 : %d%n",this.interest);
     System.out.println("=============================");
    }

    @Override
    public String toString() {
        return "NormalAccount \t\t [계좌번호 = " + getAccountNo() + "\t, 이름 = " + getName() + "\t, 현재 잔고 = " + getBalance() + "\t, 기본이자 = " + interest  + "]\n";
    }
    
    
    
    
}
