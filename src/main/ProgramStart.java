package main;

import banking.BankingSystemMain;
import commonUtil.CommonUtil;
import friendInfo.MyFriendInfoBook;
import game.threeByThree.ThreeByThreeGameMain;
import game.upAndDown.QuUpDownGame_jy;
import shopping.ShopMain;

public class ProgramStart {
    static void showMenu() {
        System.out.println("========================== 전 체 메 뉴 ================================");
        System.out.printf("1. 계좌관리 \t 2. 주소록관리 \t 3. 게임 \t 4. 상품관리 \t 5 .종료 %n");
        System.out.println("=======================================================================");
    }

    public static void main(String[] args) {

        BankingSystemMain bsm = new BankingSystemMain();
        MyFriendInfoBook mfib = new MyFriendInfoBook();
        ThreeByThreeGameMain tbtgm = new ThreeByThreeGameMain();
        QuUpDownGame_jy upndown = new QuUpDownGame_jy();
        ShopMain shop = new ShopMain();


        boolean isTrue = true;
        while (isTrue) {
            showMenu();
            int menuTempNum = CommonUtil.scanInt("원하는 메뉴");

            switch (menuTempNum) {

                case ICustomDefine.BANKING_MANAGE:
                    bsm.startBankingSystem();
                    break;
                case ICustomDefine.FRIEND_INFO_MANAGE:
                    mfib.freindInfoStart();
                    break;
                case ICustomDefine.GAME:
                    System.out.println("=========================게 임 ================================");
                    int gameTempNum = CommonUtil.scanInt("1. UpAndDown게임 \t 2. 3x3게임 \t 8. 돌아가기");
                    switch (gameTempNum) {
                        case ICustomDefine.UPANDDOWN:
                            upndown.upDownGame();
                            break;
                        case ICustomDefine.THREEBYTHREE:
                            tbtgm.gameStart();
                            break;
                        case ICustomDefine.TO_THE_TOP_MENU:
                            System.out.println("상위메뉴로 돌아갑니다.");
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                    break;
                case ICustomDefine.SHOP_MANAGE:
                    shop.shopMain();
                    break;

                case ICustomDefine.EXIT:
                    System.out.println("프로그램을 종료합니다.");
                    isTrue = false;
                    break;
                // System.exit(0);
                /*
                default:
                System.out.println("잘못된입력입니다.");
                break;
                */
            }
        }
    }
}
