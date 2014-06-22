package test12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class JProcessBarTest {
	JFrame frame = new JFrame("测试进度条");
	JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
	JCheckBox indeterminate = new JCheckBox("不确定进度");
	JCheckBox noborder = new JCheckBox("不绘制边框");
	
	public void init()
	{
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(indeterminate);
		box.add(noborder);
		frame.setLayout(new FlowLayout());
		frame.add(box);
		frame.add(bar);
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setStringPainted(true);
		noborder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bar.setBorderPainted(!noborder.isSelected());
			}
		});
		indeterminate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bar.setIndeterminate(indeterminate.isSelected());
				bar.setStringPainted(!indeterminate.isSelected());
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		for (int i = 0; i <= 100; i++) {
			bar.setValue(i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		new JProcessBarTest().init();
	}
}
