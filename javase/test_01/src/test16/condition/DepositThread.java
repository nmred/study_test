package test16.condition;

public class DepositThread extends Thread
{
	private Account account;
	private double depositAmount;
	
	public DepositThread(String name, Account acct, double depositAmount)
	{
		super(name);
		this.account = acct;
		this.depositAmount = depositAmount;
	}
	
	public void run()
	{
		for (int i = 0; i < 100; i++) {
			account.deposit(depositAmount);
		}
	}
}
