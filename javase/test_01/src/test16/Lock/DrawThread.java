package test16.Lock;

public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;
	
	public DrawThread(String name, Account acct, double drawAmount)
	{
		super(name);
		this.account = acct;
		this.drawAmount = drawAmount;
	}
	
	public void run()
	{
		account.draw(drawAmount);
	}
	
	public static void main(String[] args)
	{
		Account acct = new Account("123", 1000);
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();
	}
}
