package test.sample.pckg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeSentense1 {

	public static void main(String args[]) {
	String CSV = "Hello Edward";
	String[] values = CSV.split(" ");		
	List<String> list = new ArrayList(Arrays.asList(values));
	
	
	List<String> lst = new ArrayList<>();
	
	ArrayList<String> cities = new ArrayList<>(Arrays.asList("Edward", "How", "Hello", "doing", "are"));
	
	
	
	for(String val:list) {
		if(cities.contains(val)) {
			lst.add(val);	
		}		
	}
	
	System.out.println(lst);
	
	}
}
