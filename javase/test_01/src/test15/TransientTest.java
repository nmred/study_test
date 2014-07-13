package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("transient.txt")))
		{
			PersonTransient per = new PersonTransient("孙悟空", 500);
			oos.writeObject(per);
			PersonTransient p = (PersonTransient)ois.readObject();
			System.out.println(p.getAge());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
