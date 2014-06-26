package test13;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStatementTest {
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
	
	public void insertUseStatement() throws Exception
	{
		long start = System.currentTimeMillis();
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stmt  = conn.createStatement();
		for (int i = 0; i < 100; i++) {
			String sql = "insert into jdbc_test (jdbc_name, jdbc_desc) values(" + "'test_" + i  + "', '" + "desc_" + i + "')";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
		}
		System.out.println("使用Statement费时：" + (System.currentTimeMillis() - start));
	}
	
	public void insertUsePrepare() throws Exception
	{
		long start = System.currentTimeMillis();
		Connection conn = DriverManager.getConnection(url, user, pass);
		PreparedStatement pstmt = conn.prepareStatement("insert into jdbc_test (jdbc_name, jdbc_desc) values(?, ?)");
		for (int i = 0; i < 100; i++) {
			pstmt.setString(1, "test_" + (i + 1000));
			pstmt.setString(2, "desc_" + (i + 1000));
			pstmt.executeUpdate();
		}
		System.out.println("使用Prepare费时：" + (System.currentTimeMillis() - start));
	}
	
	public static void main(String[] args) throws Exception
	{
		PreparedStatementTest pTest = new PreparedStatementTest();
		pTest.initParam("mysql.ini");
		pTest.insertUseStatement();
		pTest.insertUsePrepare();
		
	}
	
}
