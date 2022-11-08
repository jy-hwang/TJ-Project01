package shopping;

import java.sql.SQLException;
import java.util.Scanner;
import commonUtil.CommonUtil;
import connect.IConnectImpl;

public class InsertShop extends IConnectImpl {

    /*
    PreparedStatement객체를 사용하여 작성한다.
클래스명 : InsertShop
상품명, 상품가격, 상품코드를 scanValue() 메소드로 입력받아 사용한다. 
입력이 완료되면 입력된 행의 갯수를 반환하여 출력한다. 

    
    */
    public InsertShop(){
        super("education","1234");
    }
    
    
    
    @Override
    public void execute() {
      
        try {
            //1. 쿼리문 준비
            String query = "INSERT INTO sh_goods ( g_idx , goods_name, goods_price, p_code)  VALUES(seq_total_idx.nextval,?,?,?)";
   
            //2. prepared 객체 생성 시 준비한 인수를 전달한다
            psmt = con.prepareStatement(query);
            
            //3. 사용자로 부터 insert 할 내용을 입력받는다.
            Scanner scan = new Scanner(System.in);
            System.out.println("등록하고자 하는 상품의 상품명, 가격, 제품코드를 순서대로 입력하세요");
            String gName = CommonUtil.scanValue("상품명");
            int gPrice = CommonUtil.scanInt("가격");
            String pCode = CommonUtil.scanValue("제품코드");
            
            //4. 인파라미터 설정
            psmt.setString(1, gName);
            psmt.setInt(2, gPrice);
            psmt.setString(3, pCode);
            
            int affected = psmt.executeUpdate();
            
            System.out.println(affected + " 행이 입력되었습니다.");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            close();
        }
        
    }
    
    public static void main(String[] args) {
        new InsertShop().execute();
    }
    
}
