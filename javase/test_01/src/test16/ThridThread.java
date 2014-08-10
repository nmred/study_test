package test16;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThridThread implements Callable<Integer>{
	private int i = 0;
	
	public Integer call()
	{
		for (; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "循环变量i的值：" + i);
		}
		return i;
	}
	
	public static void main(String[] args)
	{
		ThridThread rt = new ThridThread();
		FutureTask<Integer> task = new FutureTask<>(rt);
		for (int i = 0; i < 100; i++) {
			if (i == 20) {
				new Thread(task, "有返回值的线程").start();
			}
		}
		
		try {
			System.out.println("子线程的返回值:" + task.get());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
