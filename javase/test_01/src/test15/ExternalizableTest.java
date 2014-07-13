package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizableTest {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tt.txt"));
			ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("tt.txt")))
		{
			ExternalizablePerson per = new ExternalizablePerson("孙悟空", 500);
			oos.writeObject(per);
			
			ExternalizablePerson p = (ExternalizablePerson)ois.readObject();
			System.out.println(p.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
