package test15;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {
	public static void main(String[] args) throws Exception
	{
		Path path = Paths.get(".");
		System.out.println("path 里包含的路劲数量："
				+ path.getNameCount());
		System.out.println("path 的根路劲：" + path.getRoot());
		
		Path absolutePath = path.toAbsolutePath();
		System.out.println(absolutePath);
		
		System.out.println("absolutePath 的跟路劲："
				+ absolutePath.getRoot());
		System.out.println("absolutePath 里包含的路劲数量："
				+ absolutePath.getNameCount());
		System.out.println(absolutePath.getName(3));
		
		Path path2 = Paths.get("D:", "publish", "codes");
		
		System.out.println(path2);
	}
}
