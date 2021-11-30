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

	public static void save(String cnameString, String cnumberString){
		String sqlString = (new SqlString("insert", cnameString, cnumberString)).stringReturn();
		try {
			query("insert", sqlString);
			System.out.println("customer 새 항목 추가 성공!");
		}catch (Exception e) {
			System.out.println("customer 새 항목 추가 실패!");
		}
	}
	public static void save(String kg3,String kg5,String kg10,String kg20,String kg50,String kg13,String cname, String cnumber) throws SQLException{
		int propaneTotalPrice=0, bhutanTotalPrice=0;
		int ptank=0,btank=0;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		int propaneValue= Integer.parseInt(kg3)*3
				+Integer.parseInt(kg5)*5
				+Integer.parseInt(kg10)*10
				+Integer.parseInt(kg20)*20
				+Integer.parseInt(kg50)*50;
		int bhutanValue=Integer.parseInt(kg13)*13;
		String sqlString = (new SqlString("select", "price")).stringReturn();
		System.out.println("수정부분");
		//단가 검색후 계산
		ResultSet resultSet = query("select", sqlString);
		while(resultSet.next()) {
			propaneTotalPrice = resultSet.getInt("propane") * propaneValue;
			bhutanTotalPrice = resultSet.getInt("bhutan") * bhutanValue;
		}
		//탱크 현황 검색
		sqlString = (new SqlString("select", "tank")).stringReturn();
		resultSet = query("select", sqlString);
		while(resultSet.next()) {
			ptank = resultSet.getInt("ptank");
			btank = resultSet.getInt("btank");
		}
		sqlString = (new SqlString((ptank-propaneValue), (btank-bhutanValue))).stringReturn();
		query("update", sqlString);
		sqlString = "INSERT INTO `lpgstationdb`.`sell` "
				+ "(`sno`, `cname`, `cnumber`, `sday`, `kg3`, `kg5`, `kg10`, `kg20`, `kg50`, `kg13`, `sprice`) VALUES (NULL, '"
				+cname+"', '"
				+cnumber+"', '"
				+format.format(date)+"', '"
				+Integer.parseInt(kg3)+"', '"
				+Integer.parseInt(kg5)+"', '"
				+Integer.parseInt(kg10)+"', '"
				+Integer.parseInt(kg20)+"', '"
				+Integer.parseInt(kg50)+"', '"
				+Integer.parseInt(kg13)+"', '"
				+(propaneTotalPrice+bhutanTotalPrice)+"');";
		try {
			query("insert", sqlString);
			System.out.println("selldata 새 항목 추가 성공!");
		}catch (Exception e) {
			System.out.println("selldata 새 항목 추가 실패!");
			System.err.print(e);
		}
	}
}
