package friendInfo;

import java.util.Scanner;
import commonUtil.CommonUtil;
import main.ICustomDefine;

public class MyFriendInfoBook {

    public static void menuShow() {
        System.out.println("========================주 소 록 관 리 ================================");
        System.out.printf("1. 고딩친구 입력 \t 2. 대학친구 입력 \t\t 3. 전체정보 출력%n");
        System.out.printf("4. 간략정보 출력 \t 5. 친구검색 \t 6.정보수정 \t 7. 주소록삭제%n");
        System.out.printf("8. 상위메뉴로 %n");
        System.out.println("=======================================================================");
    }


    public void freindInfoStart() {
        Scanner scan = new Scanner(System.in);

        FriendInfoHandler handler = new FriendInfoHandler();

        boolean isTrue = true;

        handler.loadFriendInfo();
        while (isTrue) {
            menuShow();
            int choice = CommonUtil.scanInt("원하는 메뉴");
            switch (choice) {
                // 친구정보 입력
                case ICustomDefine.ADD_HIGH_FRIEND:
                case ICustomDefine.ADD_UNIV_FRIEND:
                    handler.addFriend(choice);
                    break;
                // 전체정보 출력
                case ICustomDefine.SHOW_ALL_INFO:
                    handler.showAllData();
                    break;
                // 간략정보출력
                case ICustomDefine.SHOW_SIMPLE_INFO:
                    handler.showSimpleData();
                    break;
                // 친구검색
                case ICustomDefine.SEARCH_FRIEND:
                    handler.searchInfo();
                    break;
                    // 정보수정
                case ICustomDefine.MODIFY_INFO:
                    handler.modifyInfo();
                    break;
                    //친구정보삭제
                case ICustomDefine.DELETE_INFO:
                    handler.deleteInfo();
                    break;

                case ICustomDefine.TO_THE_TOP_MENU:
                    System.out.println("상위메뉴로");
                    isTrue = false;
                    handler.saveFriendInfo();
                    break;
                // System.exit(0);
                default:
                    System.out.println("메뉴선택이 잘못되었습니다.");
                    break;
                // return; // 메인 메서드의 종료를 위한 return;

            }// end of switch
        } // end of while
          // scan.close();
    }// end of main method
}// end of public class

