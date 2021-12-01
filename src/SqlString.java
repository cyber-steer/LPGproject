import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SqlString{
	String sqlString;
	Date date;
	public SqlString(String kg3,String kg5,String kg10,String kg20,String kg50,String kg13,String cname, String cnumber) throws SQLException {
		int propaneTotalPrice=0, bhutanTotalPrice=0;
		int ptank=0,btank=0;
		
		//날짜 형식 정하기
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		
		//총 가스 용량 계산
		int propaneValue= Integer.parseInt(kg3)*3
				+Integer.parseInt(kg5)*5
				+Integer.parseInt(kg10)*10
				+Integer.parseInt(kg20)*20
				+Integer.parseInt(kg50)*50;
		int bhutanValue=Integer.parseInt(kg13)*13;

		sqlString = "select * from price";
		
		//단가 검색후 계산
		ResultSet resultSet = DataBase.query("select", sqlString);
		while(resultSet.next()) {
			propaneTotalPrice = resultSet.getInt("propane") * propaneValue;
			bhutanTotalPrice = resultSet.getInt("bhutan") * bhutanValue;
		}
		
		//탱크 현황 검색
		sqlString = "select * from tank";
		resultSet = DataBase.query("select", sqlString);
		while(resultSet.next()) {
			ptank = resultSet.getInt("ptank");
			btank = resultSet.getInt("btank");
		}
		sqlString = (new SqlString("tank",(ptank-propaneValue), (btank-bhutanValue))).stringReturn();
		DataBase.query("update", sqlString);
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
	}
	public SqlString(String order, String cnameString, String cnumberString) {
		sqlString = "INSERT INTO `lpgstationdb`.`customer` (`cusno` ,`cname` ,`cnumber`) VALUES ("
				+ null+",'"
				+ cnameString+"','"
				+ cnumberString+"');";
	}
	public SqlString(String table, int firthInt, int secondInt) {
		switch(table) {
		case "tank":
			sqlString = "UPDATE `lpgstationdb`.`tank` SET `ptank` = '"
					+firthInt+"',`btank` = '"
					+secondInt+"' WHERE `tank`.`bno` =1 LIMIT 1 ;";
			break;
		case "price":
			sqlString = "UPDATE `lpgstationdb`.`price` SET `propane` = '"
					+firthInt+"', `bhutan` = '"
					+secondInt+"' WHERE `price`.`pno` =1 LIMIT 1 ;";
			break;
		}
	}
	public SqlString(String table) {
		sqlString = "select * from "+table+" order by 1;";
	}
	public SqlString(String table, int number) {
		sqlString = "DELETE FROM `lpgstationdb`.`"+table+"` WHERE `customer`.`cusno` ="+number+" LIMIT 1;";
	}
	public String stringReturn() {
		return sqlString;
	}
}
