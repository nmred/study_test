package test16.Lock;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;
	public Account()
	{
		
	}
	
	public Account(String accountNo, double balance)
	{
		this.accountNo = accountNo;
		this.balance   = balance;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public String getAccountNo()
	{
		return this.accountNo;
	}
	
	public void draw(double drawAmount)
	{
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				balance -= drawAmount;
				System.out.println("\t 余额为：" + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + " 取钱失败！余额不足！");
			}
		} finally {
			lock.unlock();
		}
	}
	
	 public int hashCode()
	 {
		 return accountNo.hashCode();
	 }
	 
	 public boolean equals(Object obj)
	 {
		 if (this == obj) {
			 return true;
		 }
		 
		 if (obj != null
			&& obj.getClass() == Account.class) {
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		 }
		 
		 return false;
	 }
}
