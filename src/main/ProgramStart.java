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
        System.out.printf("1. 계좌관리 \t 2. 주소록관리 \t 3. 상품관리 \t 4. 게임\t5 .종료 %n");
        System.out.println("=======================================================================");
    }

    public static void main(String[] args) {

        BankingSystemMain bsm = new BankingSystemMain();
        MyFriendInfoBook mfib = new MyFriendInfoBook();
        ThreeByThreeGameMain tbtgm = new ThreeByThreeGameMain();
        QuUpDownGame_jy upndown = new QuUpDownGame_jy();
        ShopMain shop = new ShopMain();
        
        
        boolean isTrue = true;
        while(isTrue){
            showMenu();
            int menuTempNum = CommonUtil.scanInt("원하는 메뉴");
            
            switch(menuTempNum){
                
                case 1:
                    bsm.startBankingSystem();
                    break;
                case 2:
                    mfib.freindInfoStart();
                    break;
                case 3:
                    shop.shopMain();
                    break;
                case 4:
                    System.out.println("=========================게 임 ================================");
                    int gameTempNum = CommonUtil.scanInt("1. UpAndDown게임 \t 2. 3x3게임 \t 3. 돌아가기");
                    switch(gameTempNum){
                        case 1:
                            upndown.upDownGame();
                            break;
                        case 2:
                            tbtgm.gameStart();
                            break;
                        case 3 : 
                            System.out.println("상위메뉴로 돌아갑니다.");
                            break;
                        default :
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    isTrue = false;
                    break;
                    //System.exit(0);
                default:
                    System.out.println("잘못된입력입니다.");
                    break;
            }
        }
    }
}
