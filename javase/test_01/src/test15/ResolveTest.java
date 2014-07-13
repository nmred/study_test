package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ResolveTest {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("transient.txt"));
			ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("transient.txt")))
		{
			oos.writeObject(ResolveOrientation.HORIZONTAL);
			ResolveOrientation ori = (ResolveOrientation)ois.readObject();
			System.out.println(ori == ResolveOrientation.HORIZONTAL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
