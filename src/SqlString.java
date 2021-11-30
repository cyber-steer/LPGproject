
public class SqlString{
	String sqlString;
	public SqlString(String order, String cnameString, String cnumberString) {
		sqlString = "INSERT INTO `lpgstationdb`.`customer` (`cusno` ,`cname` ,`cnumber`) VALUES ("
				+ null+",'"
				+ cnameString+"','"
				+ cnumberString+"');";
	}
	public SqlString(int ptank, int btank) {
		sqlString = "UPDATE `lpgstationdb`.`tank` SET `ptank` = '"
				+ptank+"',`btank` = '"
				+btank+"' WHERE `tank`.`bno` =1 LIMIT 1 ;";
	}
	public SqlString(String order, String table) {
		switch(table) {
		case "price":
			sqlString = "select * from price";
			break;
		case "tank":
			sqlString = "select * from tank";
			break;
			
		}
	}
	public String stringReturn() {
		return sqlString;
	}
}
