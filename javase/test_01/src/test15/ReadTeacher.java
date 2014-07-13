package test15;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {
	public static void main(String[] args)
	{
		try (
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt")))
		{
			Teacher t1 = (Teacher)ois.readObject();
			Teacher t2 = (Teacher)ois.readObject();
			Person	per = (Person)ois.readObject();
			Teacher t3 = (Teacher)ois.readObject();
			
			System.out.println("t1 的student引用和P是否相同:" + (t1.getStudent() == per));
			System.out.println("t2 的student引用和P是否相同:" + (t2.getStudent() == per));
			System.out.println("t2 和 t3 是否是同一个对象:" + (t2 == t3));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
