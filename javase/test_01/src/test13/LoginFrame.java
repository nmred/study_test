package test13;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame {
	private final String PROP_FILE = "mysql.ini";
	private String driverString;
	private String urlString;
	private String user;
	private String pass;
	
	private JFrame jFrame = new JFrame("登录");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("登录");
	
	public void init() throws Exception
	{
		Properties connProperties = new Properties();
		connProperties.load(new FileInputStream(PROP_FILE));
		driverString = connProperties.getProperty("driver");
		urlString = connProperties.getProperty("url");
		user      = connProperties.getProperty("user");
		pass      = connProperties.getProperty("pass");
		Class.forName(driverString);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validate(userField.getText(), passField.getText())) {
					JOptionPane.showMessageDialog(jFrame, "登录成功");
				} else {
					JOptionPane.showMessageDialog(jFrame, "登录失败");
				}
			}
		});
		
		jFrame.add(userField, BorderLayout.NORTH);
		jFrame.add(passField);
		jFrame.add(loginButton, BorderLayout.SOUTH);
		jFrame.pack();
		jFrame.setVisible(true);
	}
	
	private boolean validate(String userName, String userPass)
	{
//		String sqlString = "select * from jdbc_test"
//				+ " where jdbc_name='" + userName
//				+ "' and jdbc_desc='" + userPass + "'";
		
		String sqlString = "select * from jdbc_test where jdbc_name = ? and jdbc_desc = ?";
		System.out.println(sqlString);
		try {
			Connection connection = DriverManager.getConnection(urlString, user, pass);
			//Statement stmtStatement = connection.createStatement();
			PreparedStatement pt = connection.prepareStatement(sqlString);
			pt.setString(1, userName);
			pt.setString(2, userPass);
			ResultSet rs = pt.executeQuery();
			//ResultSet rs = stmtStatement.executeQuery(sqlString);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception
	{
		new LoginFrame().init();
	}
}
