package test15;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExternalizablePerson implements Externalizable{
	private String name;
	private int age;
	
	public ExternalizablePerson(String name, int age)
	{
		System.out.println("有参数的构造器");
		this.name = name;
		this.age  = age;
	}
	
	public ExternalizablePerson()
	{
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void writeExternal(ObjectOutput out) throws IOException
	{
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
	{
		this.name = ((StringBuffer)in.readObject()).reverse().toString();
		this.age  = in.readInt();
	}
}
