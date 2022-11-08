package shopping;

import java.sql.SQLException;
import java.sql.Types;
import commonUtil.CommonUtil;
import connect.IConnectImpl;

public class DeleteShop extends IConnectImpl {

    /*
    ▶ 상품수정 및 삭제
    프로시저 작성후 CallableStatement객체를 사용하여 호출하도록 한다. 
    상품삭제
    프로시저명 : ShopDeleteGoods
    In파라미터 : 삭제할 상품의 일련번호
    Out파라미터 : 레코드 삭제 결과(1 혹은 0)
    클래스명 : DeleteShop
    
    
    */


    public DeleteShop() {
        super("education", "1234");
    }


    @Override
    public void execute() {
        try {
            System.out.println("삭제할 상품의 상품번호 입력하세요");
            // 프로시져 호출을 위한 Callable Statement 객체 생성
            cs = con.prepareCall("{call ShopDeleteGoods(?,?) }");
            // 인파라미터 설정

            cs.setInt(1, CommonUtil.scanInt("삭제할 상품번호 "));
           
            cs.registerOutParameter(2, Types.NUMERIC);
            // 프로시져 실행
            cs.execute();

            // 아웃파라미터가 문자형이므로 getString() 으로 출력한다.
            System.out.println("삭제프로시저 실행결과 :");
            System.out.print(cs.getString(2) + "건이 삭제되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void main(String[] args) {

        new DeleteShop().execute();

    }


}
