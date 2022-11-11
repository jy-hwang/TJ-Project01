package shopping;

import commonUtil.CommonUtil;

public class ShopMain {

    void showMenu() {
        System.out.println("============================ 상 품 관 리 ==============================");
        System.out.printf("1. 조회하기\t 2. 상품추가 \t 3. 상품수정 \t 4.상품삭제 \t 5. 상위메뉴로 %n");
        System.out.println("=======================================================================");
    }

    public void shopMain() {
        ShopMain sm = new ShopMain();
        boolean  isTrue = true; 
        while (isTrue) {
            sm.showMenu();
            int menuSelect = CommonUtil.scanInt("메뉴");

            switch (menuSelect) {

                // 조회하기
                case 1:
                    System.out.println("조회합니다.");
                    SelectShop selectShop = new SelectShop();
                    int menuSelect2 = CommonUtil.scanInt("1. 전체조회    2. 상품명검색");

                    if (1 == menuSelect2) {
                        selectShop.execute(1);
                    } else if (2 == menuSelect2) {
                        selectShop.execute(2);
                    }
                    break;

                // 상품추가하기
                case 2:
                    System.out.println("추가합니다.");
                    InsertShop insertShop = new InsertShop();

                    insertShop.execute();;
                    break;
                // 상품수정하기
                case 3:
                    System.out.println("수정합니다.");
                    UpdateShop updateShop = new UpdateShop();
                    updateShop.execute();;
                    break;
                // 상품삭제하기
                case 4:
                    System.out.println("삭제합니다.");
                    DeleteShop deleteShop = new DeleteShop();
                    deleteShop.execute();;
                    break;
                // 종료
                case 5:
                    System.out.println("종료합니다.");
                    isTrue = false;
                    break;
            }
        }
    }
}
