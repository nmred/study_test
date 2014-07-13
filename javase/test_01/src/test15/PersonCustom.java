package test15;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersonCustom implements Serializable{
	private String name;
	private int age;
	
	public PersonCustom(String name, int age)
	{
		System.out.println("有参数的构造器");
		this.name = name;
		this.age  = age;
	}
	
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
	{
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age = in.readInt();
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
