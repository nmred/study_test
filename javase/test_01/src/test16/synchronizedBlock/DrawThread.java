package test16.synchronizedBlock;

import test16.Account;

public class DrawThread extends Thread {
	private Account account;
	private double drawAmount;
	public DrawThread(String name, Account account, double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	public void run()
	{
		synchronized (account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("\t 余额为：" + account.getBalance());
			} else {
				System.out.println(getName() +  "取钱失败！余额不足！");
			}
		}
	}
	
	public static void main(String[] args)
	{
		Account acct = new Account("123", 1000);
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();
	}
}
