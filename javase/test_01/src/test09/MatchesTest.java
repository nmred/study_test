package test09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchesTest {
	public static void main(String[] args) {
		String[] mails = {
				"kongyeeku@163.com",
				"kongyeeku@gmail.com",
				"ligang@crazyit.org",
				"wawa@abc.xx",
		};
		
		String mailRegExString = "\\w{3,20}@\\w+\\.(com|org|cn|net|gov)";
		Pattern mailPattern = Pattern.compile(mailRegExString);
		Matcher matcher = null;
		for(String  mailString : mails) {
			if (matcher == null) {
				matcher = mailPattern.matcher(mailString);
			} else {
				matcher.reset(mailString);
			}
			
			String result = mailString + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址";
			System.out.println(result);
		}
	}
}
