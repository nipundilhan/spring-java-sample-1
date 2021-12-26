package test.pkg.normal;

import java.util.regex.Pattern;

public class JavaRegex {
	
	public static void main(String args[]){ 
		//String regex = "^[+]?\\d+([.]\\d+)?$";
		String regex = "^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$";
		System.out.println(Pattern.matches(regex, "10.00"));
		System.out.println(Pattern.matches(regex, "11"));
		System.out.println(Pattern.matches(regex, "00.00"));
		System.out.println(Pattern.matches(regex, "50."));
		System.out.println(Pattern.matches(regex, ".50"));
		System.out.println(Pattern.matches(regex, "-10.00"));
		System.out.println(Pattern.matches(regex, "10..00"));
	}

}
