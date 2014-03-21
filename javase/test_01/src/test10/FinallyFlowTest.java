package test10;

public class FinallyFlowTest {
	public static boolean test() {
		try {
			return true;
		} finally {
			return false;
		}
	}
	
	public static void main(String[] args) {
		boolean a = test();
		System.out.println(a);
	}
}
