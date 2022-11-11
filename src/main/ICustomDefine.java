package main;

public interface ICustomDefine {

    /*
     *  전체메뉴
     *  java 계좌관리, 주소록관리, 게임
     *  jdbc 상품관리
     *  종료
     */

    int BANKING_MANAGE = 1, FRIEND_INFO_MANAGE = 2, GAME = 3, SHOP_MANAGE = 4, EXIT = 5;

    /*
     * 계좌관리
     * 계좌개설 1, 입금 2, 출금 3, 계좌정보조회 4, 저장옵션 5, 이름수정 6, 계좌간이체 7, 상위메뉴로 8 
     */
    int MAKE_ACCOUNT = 1, DEPOSIT = 2, WITHDRAW = 3, INQUIRE = 4, SAVE_OPTION = 5, MODIFY_ACCOUNT = 6,
            TRANSFER = 7, TO_THE_TOP_MENU = 8;

    
    /*
     * 계좌개설시 보통계좌 1 , 신용신뢰계좌 2
     * 계좌개설시 신용신뢰계좌 등급
     * A : 7 , B : 4 , C: 2
     */
    int NORMAL_ACCOUNT = 1, HIGH_CREDIT_ACCOUNT = 2, A_RATE = 7, B_RATE = 4, C_RATE = 2;

    /*
     * 주소록 관리
     * 고딩친구 입력 1, 대학친구 입력 2, 전체정보 출력 3, 간략정보 출력 4, 친구검색 5, 정보수정 6, 주소록삭제 7, 상위메뉴로 8
     */
    
    int ADD_HIGH_FRIEND = 1, ADD_UNIV_FRIEND = 2, SHOW_ALL_INFO = 3, SHOW_SIMPLE_INFO =4, SEARCH_FRIEND = 5, MODIFY_INFO = 6, DELETE_INFO = 7;
    
    //게임  upAndDown게임 1, 3x3게임 2
    int UPANDDOWN = 1, THREEBYTHREE =2;
    
    //자동저장
    int AUTOSAVE_ON = 1, AUTOSAVE_OFF =2;
}
