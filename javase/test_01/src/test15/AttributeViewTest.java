package test15;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

public class AttributeViewTest {
	public static void main(String[] args) throws Exception
	{
		Path testPath = Paths.get("src/test15/AttributeViewTest.java");
		BasicFileAttributeView basicView = Files.getFileAttributeView(testPath, BasicFileAttributeView.class);
		BasicFileAttributes basicAttribs = basicView.readAttributes();
		
		System.out.println("创建时间：" + new Date(basicAttribs.lastModifiedTime().toMillis()));
		System.out.println("最后访问时间:" + new Date(basicAttribs.lastAccessTime().toMillis()));
		System.out.println("最后修改时间：" + new Date(basicAttribs.lastModifiedTime().toMillis()));
		System.out.println("文件大小：" + basicAttribs.size());
		
		FileOwnerAttributeView ownerView = Files.getFileAttributeView(testPath, FileOwnerAttributeView.class);
		System.out.println(ownerView.getOwner());
		UserPrincipal user = FileSystems.getDefault().getUserPrincipalLookupService().lookupPrincipalByName("nmred");
		ownerView.setOwner(user);
		
		UserDefinedFileAttributeView userView = Files.getFileAttributeView(testPath, UserDefinedFileAttributeView.class);
		java.util.List<String> attrNames = userView.list();
		for (String name : attrNames) {
			ByteBuffer buf = ByteBuffer.allocate(userView.size(name));
			userView.read(name, buf);
			buf.flip();
			String value = Charset.defaultCharset().decode(buf).toString();
			System.out.println(name + "---->" + value);
		}
		
		userView.write("发行者", Charset.defaultCharset().encode("疯狂java联盟"));
		
		DosFileAttributeView dosView = Files.getFileAttributeView(testPath, DosFileAttributeView.class);
		dosView.setHidden(true);
		dosView.setReadOnly(true);
		
	}
}
