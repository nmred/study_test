package test06;

public class GenderTest {
	public static void main(String[] args) {
		Gender g = Enum.valueOf(Gender.class, "FEMALE");
		System.out.println(g + "代表：" + g.getName());
	}
}
