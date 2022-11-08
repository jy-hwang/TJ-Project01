package banking;


public class NormalThread extends Thread {


    @Override
    public void run() {

        BankingSystemMain bsm = new BankingSystemMain();
        bsm.startBankingSystem();

    }



}
