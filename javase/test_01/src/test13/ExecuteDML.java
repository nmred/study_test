package test13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDML {
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
	}
	
	public int insertData(String sql) throws Exception
	{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stmt = conn.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public static void main(String[] args)
	{
		ExecuteDML eDml = new ExecuteDML();
		int result = 0;
		try {
			eDml.initParam("mysql.ini");
			result = eDml.insertData("insert into jdbc_test(jdbc_name, jdbc_desc) "
					+ " select madapter_name,madapter_display_name from madapter_basic"
					+ ";");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (0 != result) {
			System.out.println("---系统中共有" + result + "条记录受影响");
		}
	}
}
