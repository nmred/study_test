package test12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

public class AdjustingWidth {
	JFrame jf = new JFrame("调整表格列宽");
	JMenuBar menuBar = new JMenuBar();
	JMenu adjustModeMenu = new JMenu("调整方式");
	JMenu selectUnitMenu = new JMenu("选择单元");
	JMenu selectModeMenu = new JMenu("选择方式");
	
	JRadioButtonMenuItem[] adjustModesItem = new JRadioButtonMenuItem[5];
	JRadioButtonMenuItem[] selectModesItem = new JRadioButtonMenuItem[3];
	
	JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("选择行");
	JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("选择列");
	JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("选择单元格");
	
	ButtonGroup adjustBg = new ButtonGroup();
	ButtonGroup selectBg = new ButtonGroup();
	
	int[] adjustModes = new int[]{
			JTable.AUTO_RESIZE_OFF,
			JTable.AUTO_RESIZE_NEXT_COLUMN,
			JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS,
			JTable.AUTO_RESIZE_LAST_COLUMN,
			JTable.AUTO_RESIZE_ALL_COLUMNS
	};
	
	int[] selectModes = new int[]{
			ListSelectionModel.MULTIPLE_INTERVAL_SELECTION,
			ListSelectionModel.SINGLE_INTERVAL_SELECTION,
			ListSelectionModel.SINGLE_SELECTION
	};
	
	JTable table;
	
	Object[][] tableData =
	{
		new Object[]{"李清照", 29, "女"},
		new Object[]{"苏格拉底", 56, "男"},
		new Object[]{"李白", 35, "男"},
		new Object[]{"弄玉", 18, "女"},
		new Object[]{"虎头", 2, "男"}
	};
	
	Object[] columnTitle = {"姓名", "年龄", "性别"};
	
	public void init()
	{
		table = new JTable(tableData, columnTitle);
		
		adjustModesItem[0] = new JRadioButtonMenuItem("只调整表格");
		adjustModesItem[1] = new JRadioButtonMenuItem("只调整下一列");
		adjustModesItem[2] = new JRadioButtonMenuItem("平均调整余下列");
		adjustModesItem[3] = new JRadioButtonMenuItem("只调整最后一列");
		adjustModesItem[4] = new JRadioButtonMenuItem("平均调整所有列");
		menuBar.add(adjustModeMenu);
		for (int i = 0; i < adjustModesItem.length; i++) {
			if (i == 2) {
				adjustModesItem[i].setSelected(true);
			}
			
			adjustBg.add(adjustModesItem[i]);
			adjustModeMenu.add(adjustModesItem[i]);
			final int index = i;
			adjustModesItem[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (adjustModesItem[index].isSelected()) {
						table.setAutoResizeMode(adjustModes[index]);
					}
				}
			});
		}
		
		selectModesItem[0] = new JRadioButtonMenuItem("无限制");
		selectModesItem[1] = new JRadioButtonMenuItem("单独的连续区");
		selectModesItem[2] = new JRadioButtonMenuItem("单选");
		menuBar.add(selectModeMenu);
		for (int i= 0; i < selectModesItem.length; i++) {
			if (i == 0) {
				selectModesItem[i].setSelected(true);
			}
			selectBg.add(selectModesItem[i]);
			selectModeMenu.add(selectModesItem[i]);
			final int index = i;
			selectModesItem[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (selectModesItem[index].isSelected()) {
						table.getSelectionModel().setSelectionMode(selectModes[index]);
					}
				}
			});
		}
		
		menuBar.add(selectUnitMenu);
		rowsItem.setSelected(table.getRowSelectionAllowed());
		columnsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());
		rowsItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setRowSelectionAllowed(rowsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectUnitMenu.add(rowsItem);
		
		
		columnsItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setColumnSelectionAllowed(columnsItem.isSelected());
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectUnitMenu.add(columnsItem);
		
		cellsItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				table.clearSelection();
				table.setCellSelectionEnabled(cellsItem.isSelected());
				rowsItem.setSelected(table.getRowSelectionAllowed());
				columnsItem.setSelected(table.getColumnSelectionAllowed());
			}
		});
		selectUnitMenu.add(cellsItem);
		
		jf.setJMenuBar(menuBar);
		
		TableColumn nameColumn = table.getColumn(columnTitle[0]);
		nameColumn.setMinWidth(40);
		TableColumn ageColumn = table.getColumn(columnTitle[1]);
		ageColumn.setPreferredWidth(50);
		TableColumn genderColumn = table.getColumn(columnTitle[2]);
		genderColumn.setMaxWidth(50);
		
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new AdjustingWidth().init();
	}
}
