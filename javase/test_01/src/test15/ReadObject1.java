package test15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject1 {
	public static void main(String[] args)
	{
		try (
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt")))
		{
			Person p = (Person)ois.readObject();
			System.out.println("名字为:" + p.getName()
					+ "\n 年龄为：" + p.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
