package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WriteObjectCustom {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("custom.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("custom.txt")))
		{
			PersonCustom pcm = new PersonCustom("孙悟空", 500);
			oos.writeObject(pcm);
			
			PersonCustom p = (PersonCustom)ois.readObject();
			System.out.println("姓名：" + p.getName() + " 年龄：" + p.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
