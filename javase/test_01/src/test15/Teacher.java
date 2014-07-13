package test15;

import java.io.Serializable;

public class Teacher implements Serializable{
	private String name;
	private Person student;
	
	public Teacher(String name, Person student)
	{
		this.name = name;
		this.student = student;
	}
	
	public Person getStudent()
	{
		return student;
	}
}
