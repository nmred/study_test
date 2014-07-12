package test15;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String[] args)throws IOException
	{
		File file = new File(".");
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getAbsoluteFile());
		System.out.println(file.getAbsoluteFile().getParent());
		
		File tmpFile = File.createTempFile("aaa", ".txt", file);
		tmpFile.deleteOnExit();
		
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile 对象是否村正在：" + newFile.exists());
		
		newFile.createNewFile();
		newFile.mkdir();
		
		String[] fileList = file.list();
		System.out.println("=====当前路劲下文件和路劲如下=====");
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
		
		File[] roots = File.listRoots();
		System.out.println("====系统所有根路劲如下====");
		for (File root : roots) {
			System.out.println(root);
		}
	}
}
