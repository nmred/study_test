package test16.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
	private String accountNo;
	private double balance;
	private boolean flag = false;
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition cond = lock.newCondition();
	
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
			if (!flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				flag = false;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public void deposit(double depositAmount)
	{
		lock.lock();
		try {
			if (flag) {
				cond.await();
			} else {
				System.out.println(Thread.currentThread().getName() + "存款:" + depositAmount);
				balance += depositAmount;
				flag = true;
				cond.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
