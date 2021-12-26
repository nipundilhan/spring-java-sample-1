package test.sample.pckg.summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class sol1 {
	
	public static void main(String args[]) {
		
		List<Integer> lst = new ArrayList<>(Arrays.asList(1,1));
		
		String str = " the one that got away ";
		String[] split = str.split(" ");
		List<String> strLst = new ArrayList<>(Arrays.asList(split));
		
		strLst.stream().sorted();
	}

}
