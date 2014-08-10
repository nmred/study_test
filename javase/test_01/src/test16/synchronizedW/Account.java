package test16.synchronizedW;

public class Account 
{
	private String accountNo;
	private double balance;
	private boolean flag = false;
	
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
	
	public synchronized void draw(double drawAmount)
	{
		try {
			if (!flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "取钱:" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				flag = false;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void deposit(double depositAmount)
	{
		try {
			if (flag) {
				wait();
			} else {
				System.out.println(Thread.currentThread().getName() + "存款:" + depositAmount);
				balance += depositAmount;
				flag = true;
				notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
