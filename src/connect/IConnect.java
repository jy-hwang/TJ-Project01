package connect;

public interface IConnect {
 // 멤버변수 : 오라클 드라이버명과 커넥션 URL 을 선언
    String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
    String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";

    // 멤버 추상 메서드
    void connect(String user, String pass); // db 연결

    void execute();// 쿼리실행

    void close();// 자원반납

    //String scanValue(String title);// 사용자로 부터 문자열 입력을 받기 위해 정의

   // int scanInt(String title);// 사용자로 부터 정수 입력을 받기 위해 정의

    
}
