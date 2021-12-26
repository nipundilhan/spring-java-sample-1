package test.sample.regex;

import java.util.regex.Pattern;

public class Reg1 {

	
	public static void main(String args[]) {
		
		System.out.println(Pattern.matches("^$|[0-9]+", "10"));
		System.out.println(Pattern.matches("^$|[0-9]+", "ee"));
		
		
		System.out.println(Pattern.matches("^$|\\d{1,20}\\.\\d{1,5}$", "8.8"));
		System.out.println(Pattern.matches("^$|\\d{1,20}\\.\\d{1,5}$", "czx"));
	}
}
