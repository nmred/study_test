package test12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class JProcessBarTest2 {
	JFrame frame = new JFrame("测试进度条");
	JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
	JCheckBox indeterminate = new JCheckBox("不确定进度");
	JCheckBox noBorder = new JCheckBox("不绘制边框");
	
	public void init()
	{
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(indeterminate);
		box.add(noBorder);
		frame.setLayout(new FlowLayout());
		frame.add(box);
		frame.add(bar);
		bar.setStringPainted(true);
		noBorder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				bar.setBorderPainted(!noBorder.isSelected());
			}
		});
		
		final SimulatedActivity target = new SimulatedActivity(1000);
		new Thread(target).start();
		bar.setMinimum(0);
		bar.setMaximum(target.getAmount());
		
		Timer timer = new Timer(300, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bar.setValue(target.getCurrent());
			}
		});
		timer.start();
		indeterminate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				bar.setIndeterminate(indeterminate.isSelected());
				bar.setStringPainted(!indeterminate.isSelected());
			}   
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new JProcessBarTest2().init();
	}
	
	class SimulatedActivity implements Runnable
	{
		private volatile int current;
		private int amount;
		
		public SimulatedActivity(int amount)
		{
			current = 0;
			this.amount = amount;
		}
		
		public int getAmount()
		{
			return amount;
		}
		
		public int getCurrent()
		{
			return current;
		}
		
		public void run()
		{
			while (current < amount) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}
				
				current++;
			}
		}
	}
}
