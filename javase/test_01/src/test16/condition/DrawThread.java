package test16.condition;

public class DrawThread extends Thread
{
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
		for (int i = 0; i < 100; i++) {
			account.draw(drawAmount);
		}
	}
}
