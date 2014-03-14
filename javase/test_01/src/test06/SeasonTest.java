package test06;

public class SeasonTest {
	public SeasonTest(Season s) {
		System.out.println(s.getName() + ", 这真是一个" + s.getDesc() + "的季节。");
	}
	
	public static void main(String[] args) {
		new SeasonTest(Season.FALL);
	}
}
