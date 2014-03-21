package test09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringReg {
	public static void main(String[] args) {
		String[] msgsStrings ={
				"Java has regular expressions in 1.4",
				"regular expressions now expressing in Java",
				"Java represses oracular expressions",
		};
		for (String msg : msgsStrings) {
			System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
			System.out.println(Arrays.toString(msg.split(" ")));
		}
	}
}
