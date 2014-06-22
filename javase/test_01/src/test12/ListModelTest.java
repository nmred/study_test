package test12;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListModelTest {
	private JFrame mainWin = new JFrame("测试ListModel");
	private JList<BigDecimal>numScopeList = new JList<>(new NumberListModel(1, 21, 2));
	private JComboBox<BigDecimal>numScopeSelector = new JComboBox<>(new NumberComboBoxModel(0.1, 1.2, 0.1));
	private JTextField showVal = new JTextField(10);
	
	public void init()
	{
		numScopeList.setVisibleRowCount(4);
		numScopeList.setSelectionInterval(2, 4);
		numScopeList.setFixedCellHeight(30);
		numScopeList.setFixedCellWidth(90);
		numScopeList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				List<BigDecimal>nums = numScopeList.getSelectedValuesList();
				showVal.setText("");
				for(BigDecimal num : nums) {
					showVal.setText(showVal.getText() + num.toString() + ", ");
				}
			}
		});
		
		numScopeSelector.setMaximumRowCount(5);
		numScopeSelector.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				Object num = numScopeSelector.getSelectedItem();
				showVal.setText(num.toString());
			}
		});
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(numScopeList));
		JPanel p = new JPanel();
		p.add(numScopeSelector);
		box.add(p);
		
		JPanel bottom = new JPanel();
		bottom.add(new JLabel("您选择的值是:"));
		bottom.add(showVal);
		mainWin.add(box);
		mainWin.add(bottom, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new ListModelTest().init();
	}
	
	class NumberListModel extends AbstractListModel<BigDecimal>
	{
		protected BigDecimal start;
		protected BigDecimal end;
		protected BigDecimal step;
		
		public NumberListModel(double start, double end, double step)
		{
			this.start = BigDecimal.valueOf(start);
			this.end   = BigDecimal.valueOf(end);
			this.step  = BigDecimal.valueOf(step);
		}
		
		public int getSize()
		{
			return (int)Math.floor(end.subtract(start).divide(step).doubleValue()) + 1;
		}
		
		public BigDecimal getElementAt(int index)
		{
			return BigDecimal.valueOf(index).multiply(step).add(start);
		}
	}
	
	class NumberComboBoxModel extends NumberListModel implements ComboBoxModel<BigDecimal>
	{
		private int selectId = 0;
		public NumberComboBoxModel(double start, double end, double step)
		{
			super(start, end, step);
		}
		
		public void setSelectedItem(Object anItem)
		{
			if (anItem instanceof BigDecimal) {
				BigDecimal target = (BigDecimal)anItem;
				selectId = target.subtract(super.start).divide(step).intValue();
			}
		}
		
		public BigDecimal getSelectedItem()
		{
			return BigDecimal.valueOf(selectId).multiply(step).add(start);
		}
	}
}
