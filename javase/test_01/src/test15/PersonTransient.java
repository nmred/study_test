package test15;

import java.io.Serializable;

public class PersonTransient implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String name;
	private transient int age;
	
	public PersonTransient(String name, int age)
	{
		System.out.println("有参数的构造器");
		this.name = name;
		this.age  = age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getAge()
	{
		return age;
	}
}
