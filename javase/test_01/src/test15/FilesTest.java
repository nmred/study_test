package test15;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesTest {
	public static void main(String[] args) throws Exception
	{
		Files.copy(Paths.get("src/test15/FilesTest.java"), new FileOutputStream("a.txt"));
		System.out.println("FilesTest.java 是否是隐蔽文件：" + Files.isHidden(Paths.get("src/test15/FilesTest.java")));
		
		List<String> lines = Files.readAllLines(Paths.get("src/test15/FilesTest.java"), Charset.forName("UTF-8"));
		System.out.println(lines);
		
		System.out.println("FilesTest.java的大小为："
				+ Files.size(Paths.get("src/test15/FilesTest.java")));
		
		List<String> poem = new ArrayList<>();
		poem.add("水晶潭底影预约");
		poem.add("清徐凤中碧竿横");
		Files.write(Paths.get("pome.txt"), poem, Charset.forName("UTF-8"));
		
		FileStore cStore = Files.getFileStore(Paths.get("C:"));
		System.out.println("C:共有空间： " + cStore.getTotalSpace());
		System.out.println("C:可用空间:" + cStore.getUsableSpace());
	}
}
