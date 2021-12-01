import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBase {
	public static Connection connection;
	
	public static void dbConnect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 검색 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
			System.err.println("error = "+e);
		}
		
		String urlString = "jdbc:mysql://localhost/lpgstationdb?useUnicode=yes&characterEncoding=UTF8";
		try {
			connection = DriverManager.getConnection(urlString, "root", "apmsetup");
			System.out.println("데이터 베이스 연결 성공!");
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 실패!");
		}
	}
	public static void dbDis() {
		try {
			if(connection != null)
				connection.close();
			System.out.println("DB 연동 해제 성공!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("DB 연동 해제 실패!");
		}
	}
	
	public static ResultSet query(String order, String sql)throws SQLException{
		Statement statement = connection.createStatement();
		ResultSet resultSet = null;
		if(order == "select") {
			resultSet=statement.executeQuery(sql);
		}
		else {
			statement.execute(sql);
		}
		return resultSet;
	}
	public static void save(String sqlString){
		try {
			query("insert", sqlString);
			System.out.println("새 항목 추가 성공!");
		}catch (Exception e) {
			System.out.println("새 항목 추가 실패!");
		}
	}
	public static void delete(String sqlString) {
		try {
			query("delete", sqlString);
			System.out.println("항목 삭제 성공!");
		}catch (Exception e) {
			System.out.println("항목 삭제 실패!");
		}
	}
	public static void update(String sqlString) {
		try {
			query("update", sqlString);
			System.out.println("항목 수정 성공!");
		}catch (Exception e) {
			System.out.println("항목 수정 실패!");
		}
	}
	public static void save(String kg3,String kg5,String kg10,String kg20,String kg50,String kg13,String cname, String cnumber) throws SQLException{

		try {
			String sqlString = (new SqlString(kg3, kg5, kg10, kg20, kg50, kg13, cname, cnumber)).stringReturn();
			query("insert", sqlString);
			System.out.println("sell 새 항목 추가 성공!");
		}catch (Exception e) {
			System.out.println("sell 새 항목 추가 실패!");
			System.err.print(e);
		}
	}
}
