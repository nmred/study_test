package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mutable.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mutable.txt")))
		{
			Person per = new Person("孙悟空", 500);
			oos.writeObject(per);
			
			per.setName("猪八戒");
			
			oos.writeObject(per);
			Person per1 = (Person)ois.readObject();
			Person per2 = (Person)ois.readObject();
			
			System.out.println(per1 == per2);
			System.out.println(per2.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
