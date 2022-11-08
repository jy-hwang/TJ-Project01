package banking;

// 종속 스레드 (Daemon Thread)
public class AutoSaver extends Thread {

    AccountManager am;

    public AutoSaver(AccountManager am) {
        this.am = am;

    }

    // 데몬 스레드 만들기
    @Override
    public void run() {

        while (true) {

            try {
                sleep(5000);
                System.out.println("autosaver 실행");
                am.autoSave();
            } catch (InterruptedException e) {
                // e.printStackTrace();
                System.out.println("autosaver 실행종료");
                break;
            }

        }



    }

}
