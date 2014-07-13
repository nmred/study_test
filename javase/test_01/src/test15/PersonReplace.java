package test15;

import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class PersonReplace implements Serializable{
	private String name;
	private int age;
	
	public PersonReplace(String name, int age)
	{
		System.out.println("有参数的构造器");
		this.name = name;
		this.age  = age;
	}
	
	private Object writeReplace() throws ObjectStreamException
	{
		ArrayList<Object> list = new ArrayList<>();
		list.add(name);
		list.add(age);
		
		return list;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
}
