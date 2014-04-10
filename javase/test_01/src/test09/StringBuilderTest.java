package test09;

public class StringBuilderTest {
	public static void main(String[] args) {
		StringBuilder sbBuilder = new StringBuilder();
		sbBuilder.append("Java");
		sbBuilder.insert(0, "Hello ");
		sbBuilder.replace(5, 6, ",");
		sbBuilder.delete(5, 6);
		sbBuilder.reverse();
		System.out.println(sbBuilder);
		System.out.println(sbBuilder.length());
		System.out.println(sbBuilder.capacity());
		sbBuilder.setLength(5);
		System.out.println(sbBuilder);
		
	}
}
