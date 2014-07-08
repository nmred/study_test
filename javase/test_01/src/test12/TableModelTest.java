package test12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class TableModelTest {
	JFrame jf = new JFrame("数据表管理工具");
	private JScrollPane scrollPane;
	private ResultSetTableModel model;
	private JComboBox<String>tableNames = new JComboBox<>();
	private JTextArea changeMsg = new JTextArea(4, 80);
	private ResultSet rs;
	private Connection conn;
	private Statement stmt;
	
	public void init()
	{
		tableNames.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (scrollPane != null) {
						jf.remove(scrollPane);
					}
					
					String tableName = (String)tableNames.getSelectedItem();
					if (rs != null) {
						rs.close();
					}
					String query = "select * from " + tableName;
					rs = stmt.executeQuery(query);
					model = new ResultSetTableModel(rs);
					model.addTableModelListener(new TableModelListener() {
						
						@Override
						public void tableChanged(TableModelEvent e) {
							int row = e.getFirstRow();
							int column = e.getColumn();
							changeMsg.append("修改的列：" + column
									+ ", 修改的行：" + row + "修改后的值:"
									+ model.getValueAt(row, column));
						}
					});
					JTable table = new JTable(model);
					scrollPane = new JScrollPane(table);
					jf.add(scrollPane, BorderLayout.CENTER);
					jf.validate();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JPanel p = new JPanel();
		p.add(tableNames);
		jf.add(p, BorderLayout.NORTH);
		jf.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);
		try {
			conn = getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet tables = meta.getTables(null, null, null, new String[]{"TABLE"});
			while (tables.next()) {
				tableNames.addItem(tables.getString(3));
			}
			tables.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					if (conn != null) conn.close();
				} catch (SQLException exec) {
					exec.printStackTrace();
				}
			}
		});
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	private static Connection getConnection() throws SQLException, IOException, ClassNotFoundException
	{
		Properties props = new Properties();
		props.load(new FileInputStream("mysql.ini"));
		String drivers = props.getProperty("driver");
		String url     = props.getProperty("url");
		String user    = props.getProperty("user");
		String pass    = props.getProperty("pass");
		
		Class.forName(drivers);
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void main(String[] args)
	{
		new TableModelTest().init();
	}
	
 	class ResultSetTableModel extends AbstractTableModel
	{
		private ResultSet rs;
		private ResultSetMetaData rsmd;
		
		public ResultSetTableModel(ResultSet aResultSet)
		{
			rs = aResultSet;
			try {
				rsmd = rs.getMetaData();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public String getColumnName(int c)
		{
			try {
				return rsmd.getColumnName(c + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return "";
			}
		}
		
		public int getColumnCount()
		{
			try {
				return rsmd.getColumnCount();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public Object getValueAt(int r, int c)
		{
			try {
				rs.absolute(r + 1);
				return rs.getObject(c + 1);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public int getRowCount()
		{
			try {
				rs.last();
				return rs.getRow();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
		}
		
		public boolean isCellEditable(int rowIndex, int columnIndex)
		{
			return true;
		}
		
		public void setValueAt(Object aValue, int row, int column)
		{
			try {
				rs.absolute(row + 1);
				rs.updateObject(column + 1, aValue);
				rs.updateRow();
				
				// 触发单元格的修改事件
				fireTableCellUpdated(row, column);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
