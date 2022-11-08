package connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IConnectImpl implements IConnect {

    // 멤버변수

    public Connection con;

    public Statement stmt;

    public PreparedStatement psmt;

    public ResultSet rs;

    public CallableStatement cs;

    // 기본생성자
    public IConnectImpl() {}

    // 인수생성자 아이디와 비밀번호
    public IConnectImpl(String user, String pass) {

        System.out.println("인자 생성자 호출");

        try {
            // 인터페이스에 선언된 멤버상수를 그대로 사용함.
            Class.forName(ORACLE_DRIVER);
            // 인수로 받은 계정정보를 통해 DB 연결
            connect(user, pass);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    @Override
    public void connect(String user, String pass) {

        try {
            con = DriverManager.getConnection(ORACLE_URL, user, pass);
            System.out.println("DB에 접속되었습니다.");
        } catch (SQLException e) {
            System.out.println("DB 연결 오류");
            e.printStackTrace();
        }

    }

    @Override
    public void execute() {

    }

    @Override
    public void close() {

    }

    public void execute(int temp) {}


}
