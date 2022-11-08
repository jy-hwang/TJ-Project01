package friendInfo;

import java.util.Scanner;
import commonUtil.CommonUtil;

public class MyFriendInfoBook {
    /*
     * 매개변수도 없고 반환타입도 없는 메서드
     */
    public static void menuShow() {
        System.out.println("========================주 소 록 관 리 ================================");
        System.out.printf("1. 고딩친구 입력 \t 2. 대학친구 입력 \t\t 3. 전체정보 출력%n");
        System.out.printf("4. 간략정보 출력 \t 5. 친구검색 \t 6. 주소록삭제 \t 7. 상위메뉴로%n");
        System.out.println("=======================================================================");
    }

   
   public void freindInfoStart(){
        Scanner scan = new Scanner(System.in);

        FriendInfoHandler handler = new FriendInfoHandler();

        boolean isTrue = true;

        handler.loadFriendInfo();
        while (isTrue) {
            menuShow();
            int choice = CommonUtil.scanInt("원하는 메뉴");
            switch (choice) {
                case 1:
                case 2:
                    handler.addFriend(choice);
                    break;
                case 3:
                    handler.showAllData();
                    break;
                case 4:
                    handler.showSimpleData();
                    break;
                case 5:
                    handler.searchInfo();
                    break;
                case 6:
                    handler.deleteInfo();
                    break;

                case 7:
                    System.out.println("프로그램종료");
                    isTrue = false;
                    handler.saveFriendInfo();
                    break;
//                    System.exit(0);
                default:
                    System.out.println("메뉴선택이 잘못되었습니다.");
                    break;
                // return; // 메인 메서드의 종료를 위한 return;

            }// end of switch
        } // end of while
          // scan.close();
    }// end of main method
}// end of public class

