package test16;

class MyHandler implements Thread.UncaughtExceptionHandler
{
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println(t + " 线程出现了异常:" + e);
	}
}

public class ExHandler {
	public static void main(String[] args)
	{
		Thread.currentThread().setUncaughtExceptionHandler(new MyHandler());
		int a = 5 / 0;
		System.out.println("程序正常结束");
	}
}
