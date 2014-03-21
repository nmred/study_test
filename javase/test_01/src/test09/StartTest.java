package test09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartTest {
	public static void main(String[] args) {
		String regString = "Java is very easy!";
		System.out.println("目标字符串是：" + regString);
		Matcher matcher = Pattern.compile("\\w+").matcher(regString);
		while(matcher.find()) {
			System.out.println(matcher.group() + "子串的起始位置：" + matcher.start() + "，其结束位置：" + matcher.end());
		}
	}
}
