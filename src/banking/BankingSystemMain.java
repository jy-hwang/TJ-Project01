package banking;

import java.util.InputMismatchException;
import java.util.Scanner;
import commonUtil.CommonUtil;
import game.threeByThree.ThreeByThreeGameMain;
import main.ICustomDefine;
import shopping.ShopMain;

public class BankingSystemMain {

    public void startBankingSystem() {

        AccountManager am = new AccountManager();
        AutoSaver as = new AutoSaver(am);

        ShopMain sm = new ShopMain();

        Scanner scanner = new Scanner(System.in);
        am.loadAccountInfo();
        boolean isTrue = true;
        while (isTrue) {
            am.showMenu();
            try {

                int temp = CommonUtil.scanInt("원하는 메뉴");

                if (temp >= ICustomDefine.MAKE_ACCOUNT || temp <= ICustomDefine.TO_THE_TOP_MENU) {
                    switch (temp) {
                        case ICustomDefine.MAKE_ACCOUNT:
                            am.makeAccount();
                            break;
                        case ICustomDefine.DEPOSIT:
                            am.depositMoney();
                            break;
                        case ICustomDefine.WITHDRAW:
                            am.withdrawMoney();
                            break;
                        case ICustomDefine.INQUIRE:
                            am.showAccInfo();
                            break;
                        case ICustomDefine.SAVE_OPTION:
                            am.saveOption(as);
                            break;
                        case ICustomDefine.MODIFY_ACCOUNT:
                            am.modifyName();
                            break;
                        case ICustomDefine.TRANSFER:
                            am.transfer();
                            break;
                        case ICustomDefine.TO_THE_TOP_MENU:
                            System.out.println("프로그램을 종료합니다.");
                            am.saveAccountInfo();
                            isTrue = false;
                            break;
                        default:
                            System.out.println("메뉴를 다시 확인 해주세요.");
                    }// end of switch
                } else {
                    MenuSelectException ex = new MenuSelectException();
                    throw ex;
                }
            } catch (InputMismatchException e) {
                e.getStackTrace();
                System.out.println("문자를 입력할 수 없습니다.");
                scanner.nextLine();
            } catch (MenuSelectException e) {
                e.getStackTrace();
                System.out.println("MenuSelectException");
                scanner.nextLine();
            }
        } // end of while
    }
}// end of class
