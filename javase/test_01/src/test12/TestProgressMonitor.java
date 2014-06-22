package test12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ProgressMonitor;
import javax.swing.Timer;

public class TestProgressMonitor {
	Timer timer;
	public void init()
	{
		final SimulatedActivity target = new SimulatedActivity(1000);
		final Thread targetTread = new Thread(target);
		targetTread.start();
		final ProgressMonitor dialog = new ProgressMonitor(null, "等待任务", "已完成", 0, target.getAmount());
		timer = new Timer(300, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialog.setProgress(target.getCurrent());
				if (dialog.isCanceled()) {
					timer.stop();
					targetTread.interrupt();
					System.exit(0);
				}
			}
		});
		timer.start();
	}

	public static void main(String[] args)
	{
		new TestProgressMonitor().init();
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
