package shopping;

import java.sql.SQLException;
import java.text.DecimalFormat;
import commonUtil.CommonUtil;
import connect.IConnectImpl;

public class SelectShop extends IConnectImpl {

    /*
     Statement객체를 사용하여 작성한다.
    클래스명 : SelectShop
    3-1. select * from SH_GOODS; 확인하기  - ok
    3-2. 자바에서 쿼리실행후 , 콘솔출력창에 결과 출력해보기
    3-3. 검색할 상품명을 입력받은 후 
    3-4. like를 통해 해당조건에 맞는 레코드만 출력한다. 
    출력항목 : 일련번호, 상품명, 가격, 등록일, 제품코드
    단, 등록일은 0000-00-00 00:00 형태로 출력해야 한다.
    상품가격은 세자리마다 컴마를 찍어준다.
    Statement객체는 인파라미터를 통한 동적쿼리를 작성할 수 없으므로 순수 Java변수를 사용한다.
     */

    public SelectShop() {
        super("education", "1234");
    }

    @Override
    public void execute(int temp) {

        try {
            stmt = con.createStatement();

          
            // 1. 전체조회
            
           

           String query ="";
            if(1 ==  temp){
                query = " SELECT * FROM sh_goods ";
                rs = stmt.executeQuery(query);
            }else if(2 == temp){
                String gName = CommonUtil.scanValue("상품명");
                // 2. like 조회
                query = " SELECT * FROM sh_goods where goods_name like '%" + gName + "%'";

                rs = stmt.executeQuery(query);
            }
            
            System.out.println("실행하는 쿼리 : " + query);
            System.out.printf("%s %-10s\t %-10s\t %-18s\t %-10s\t\n", "상품번호", "상품명", "가격", "등록일",
                    "제품코드");

            while (rs.next()) {
                String id = rs.getString("g_idx");
                String name = rs.getString("goods_name");
                int price = rs.getInt("goods_price");

                String regiDate = rs.getString("regidate").substring(0, 16);
                // java.sql.Date regiDate = rs.getDate("regidate");
                String pCode = rs.getString("p_code");
                // String name = rs.getString("name");

                DecimalFormat df = new DecimalFormat("#,##0");

                // int sal = rs.getInt("salary");
                System.out.printf("%s \t %-8s\t %-10s\t %-6s\t %-6s\t\n", id, name,
                        df.format(price), regiDate, pCode);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public static void main(String[] args) {
        SelectShop selectShop = new SelectShop();

        selectShop.execute();;

    }

}
