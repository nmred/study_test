package test15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
	public static void main(String[] args)
	{
		try (
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("replace.txt"));
			ObjectInputStream  ois = new ObjectInputStream(new FileInputStream("replace.txt")))
		{
			PersonReplace per = new PersonReplace("孙悟空", 500);
			oos.writeObject(per);
			
			ArrayList<Object> list = (ArrayList<Object>)ois.readObject();
			
			System.out.println(list);
		}  catch (Exception e) {
			e.printStackTrace();
		}
	}
}
