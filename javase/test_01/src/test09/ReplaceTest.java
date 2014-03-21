package test09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTest {
	public static void main(String[] args) {
		String[] msgsStrings ={
				"Java has regular expressions in 1.4",
				"regular expressions now expressing in Java",
				"Java represses oracular expressions",
		};
		Pattern pattern = Pattern.compile("re\\w*");
		Matcher matcher = null;
		for (int i = 0, len = msgsStrings.length; i < len; i++) {
			if (matcher == null) {
				matcher = pattern.matcher(msgsStrings[i]);
			} else {
				matcher = matcher.reset(msgsStrings[i]);
			}
			
			System.out.println(matcher.replaceAll("哈哈:)"));
		}
	}
}
