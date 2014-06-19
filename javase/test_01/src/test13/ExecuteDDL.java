package test13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {
	private String driver;
	private String urlString;
	private String userString;
	private String pass;
	
	public void initParam(String paramFile) throws Exception
	{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		urlString = props.getProperty("url");
		userString = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	public void createTable(String sql) throws Exception
	{
		System.out.println(driver);
		Class.forName(driver);
		try {
			Connection connection = DriverManager.getConnection(urlString, userString, pass);
			Statement stmtStatement = connection.createStatement();
			stmtStatement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ExecuteDDL edDdl = new ExecuteDDL();
		edDdl.initParam("mysql.ini");
		edDdl.createTable("create table jdbc_test"
				+ "(jdbc_id int auto_increment primary key,"
				+ "jdbc_name varchar(255),"
				+ "jdbc_desc text);");
		System.out.println("-----建表成功-----");
	}
}
