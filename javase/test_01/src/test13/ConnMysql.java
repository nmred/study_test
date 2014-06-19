package test13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnMysql {
	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.48.128:3306/swan_soft", "swan", "aaaaa123");
			Statement stmtStatement = connection.createStatement();
			
			ResultSet rSet = stmtStatement.executeQuery("select * from device_key");
			while(rSet.next()) {
				System.out.println(rSet.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
