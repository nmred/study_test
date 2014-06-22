package test12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

public class JSpinnerTest {
	final int SPINNER_NUM = 6;
	JFrame mainWin = new JFrame("微调控制器示范");
	Box spinnerBox = new Box(BoxLayout.Y_AXIS);
	JSpinner[] spinners = new JSpinner[SPINNER_NUM];
	JLabel[] valLabels = new JLabel[SPINNER_NUM];
	JButton okBn = new JButton("确定");
	
	public void init()
	{
		for (int i = 0; i < SPINNER_NUM; i++) {
			valLabels[i] = new JLabel();
		}
		
		spinners[0] = new JSpinner();
		addSpinner(spinners[0], "普通", valLabels[0]);
		
		SpinnerNumberModel numberModel = new SpinnerNumberModel(3.4, -1.1, 4.3, 0.1);
		spinners[1] = new JSpinner(numberModel);
		addSpinner(spinners[1], "数值范围", valLabels[1]);
		
		
		String[] books = new String[] {
				"轻量级Java EE 企业应用实战",
				"疯狂Java讲义",
				"疯狂Ajax讲义"
		};
		SpinnerListModel bookModel = new SpinnerListModel(books);
		spinners[2] = new JSpinner(bookModel);
		addSpinner(spinners[2], "字符串序列值", valLabels[2]);
		
		ArrayList<ImageIcon> icons = new ArrayList<>();
		icons.add(new ImageIcon("image/1.gif"));
		icons.add(new ImageIcon("image/2.gif"));
		spinners[3] = new JSpinner(new SpinnerListModel(icons));
		addSpinner(spinners[3], "图标序列值", valLabels[3]);
		
		Calendar cal = Calendar.getInstance();
		Date init = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -3);
		Date start = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, 8);
		Date end = cal.getTime();
		SpinnerDateModel dateModel = new SpinnerDateModel(init, start, end, Calendar.HOUR_OF_DAY);
		spinners[4] = new JSpinner(dateModel);
		addSpinner(spinners[4], "时间范围", valLabels[4]);
		
		dateModel = new SpinnerDateModel();
		spinners[5] = new JSpinner(dateModel);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinners[5], "公元yyyy年MM月dd日HH时");
		spinners[5].setEditor(editor);
		addSpinner(spinners[5], "使用DateEditor", valLabels[5]);
		
		okBn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < SPINNER_NUM; i++) {
					valLabels[i].setText(spinners[i].getValue().toString());
				}
			}
		});
		
		JPanel bnpJPanel = new JPanel();
		bnpJPanel.add(okBn);
		mainWin.add(spinnerBox, BorderLayout.CENTER);
		mainWin.add(bnpJPanel, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	
	public void addSpinner(JSpinner spinner, String description, JLabel valLabel)
	{
		Box box = new Box(BoxLayout.X_AXIS);
		JLabel desc = new JLabel(description + ":");
		desc.setPreferredSize(new Dimension(100, 30));
		box.add(desc);
		box.add(spinner);
		valLabel.setPreferredSize(new Dimension(180, 30));
		box.add(valLabel);
		spinnerBox.add(box);
	}
	
	public static void main(String[] args)
	{
		new JSpinnerTest().init();
	}
}
