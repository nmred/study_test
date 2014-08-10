package test16;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThreadTest implements Runnable
{
	public void run()
	{
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的i 值为:" + i);
		}
	}
}

public class ThreadPoolTest {
	public static void main(String[] args) throws Exception
	{
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.submit(new MyThreadTest());
		pool.submit(new MyThreadTest());
		pool.shutdown();
	}
}
