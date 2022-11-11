package shopping;

import java.sql.SQLException;
import java.sql.Types;
import commonUtil.CommonUtil;
import connect.IConnectImpl;

public class UpdateShop extends IConnectImpl {

    /*
    ▶ 상품수정 및 삭제
프로시저 작성후 CallableStatement객체를 사용하여 호출하도록 한다. 
상품수정
프로시저명 : ShopUpdateGoods
In파라미터 : 상품명, 가격, 제품코드, 수정할 상품의 일련번호
Out파라미터 : 레코드 수정 결과(1 혹은 0)
클래스명 : UpdateShop

    */
    
    public UpdateShop(){
        super("education","1234");
    }
    
    
    @Override
    public void execute() {
        try {
            System.out.println("수정할 상품의 상품번호, 상품명,가격,상품코드를 차례대로 입력하세요");
            // 프로시져 호출을 위한 Callable Statement 객체 생성
            cs = con.prepareCall("{call ShopUpdateGoods(?,?,?,?,?) }");
            // 인파라미터 설정
            
            
            cs.setInt(1, CommonUtil.scanInt("수정할 상품번호 "));
            cs.setString(2, CommonUtil.scanValue("상품명 "));
            cs.setInt(3, CommonUtil.scanInt("가격"));
            cs.setInt(4, CommonUtil.scanInt("상품코드"));
            // 아웃파라미터 반환타입설정
            cs.registerOutParameter(5, Types.NUMERIC);
            // 프로시져 실행
            cs.execute();

            // 아웃파라미터가 문자형이므로 getString() 으로 출력한다.
            System.out.println("수정프로시저 실행결과 :");
            System.out.print(cs.getString(5) + "행이 수정되었습니다.\n");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            close();
        }
    }
    
    
    public static void main(String[] args) {
        
        new UpdateShop().execute();
        
        
    }
    
}
