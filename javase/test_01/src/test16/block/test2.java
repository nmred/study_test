package test16.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread
{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	
	public void run()
	{
		String[] strArr = new String[]
		{
			"Java",
			"Structs",
			"Springs"
		};
		
		for (int i = 0; i < 9999999; i++) {
			System.out.println(getName() + "生产者准备生产元素！");
			try {
				Thread.sleep(200);
				bq.put(strArr[i % 3]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println(getName() +  "生产完成：" + bq);
		}
	}
}

class Consumer extends Thread
{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	
	public void run()
	{
		while (true) {
			System.out.println(getName() + "消费者准备消费集合元素！");
			try {
				Thread.sleep(200);
				bq.take();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			System.out.println(getName() + "消费完成：" + bq);
		}
	}
}

public class test2 {
	public static void main(String[] args)
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		new Producer(bq).start();
		new Producer(bq).start();
		new Producer(bq).start();
		new Consumer(bq).start();
	}
}
