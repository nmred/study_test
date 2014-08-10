package test16;

class LocalAccount
{	
	private ThreadLocal<String> name = new ThreadLocal<>();
	
	public LocalAccount(String str)
	{
		this.name.set(str);
	}
	
	public String getName()
	{
		return this.name.get();
	}
	
	public void setName(String str)
	{
		this.name.set(str);
	}
}
public class ThreadLocalTest extends Thread 
{
	private LocalAccount acctount;
	
	public ThreadLocalTest(LocalAccount acct, String name)
	{
		super(name);
		this.acctount = acct;
	}
	
	public void run()
	{
		for (int i = 0; i < 10; i++) {
			if (i == 6) {
				acctount.setName(getName());
			}
			System.out.println(acctount.getName() + "账户的i值" + i);
		}
	}
	
	public static void main(String[] args)
	{
		LocalAccount at = new LocalAccount("初始名");
		
		new ThreadLocalTest(at, "线程甲").start();
		new ThreadLocalTest(at, "线程乙").start();
	}
}
