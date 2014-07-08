package test13;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Properties;

public class CallableStatementTest {
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	public void initParam(String paramFile) throws Exception
	{
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url    = props.getProperty("url");
		user   = props.getProperty("user");
		pass   = props.getProperty("pass");
		Class.forName(driver);
	}
	
	public void callProcedure() throws Exception
	{
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			CallableStatement stmt = connection.prepareCall("{call add_pro(?, ? , ?)}");
			stmt.setInt(1, 4);
			stmt.setInt(2, 5);
			stmt.registerOutParameter(3, Types.INTEGER);
			stmt.execute();
			System.out.println("执行结果是：" + stmt.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		CallableStatementTest cTest = new CallableStatementTest();
		cTest.initParam("mysql.ini");
		cTest.callProcedure();
	}
}
