package test06;

public class LocalInnerClass {
	public static void main(String[] args) {
		class InnerBase {
			int a;
		}
		class InnerSub extends InnerBase {
			int b;
		}
		
		InnerSub is = new InnerSub();
		is.a = 5;
		is.b = 9;
		
		System.out.println("InnerSub 对象的a 和b Field是：" + is.a + "," + is.b);
	}
}
