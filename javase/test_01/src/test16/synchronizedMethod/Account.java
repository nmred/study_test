package test16.synchronizedMethod;

public class Account {
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
	
	public synchronized void draw(double drawAmount)
	{
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
