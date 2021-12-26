package test.sample.pckg.summary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Summary1 {

	
	public static void main() {
		
		String sentense = "Hello Edward how are you";
		String[] values = sentense.split(" ");		
		List<String> list = new ArrayList(Arrays.asList(values));
		
		ArrayList<String> cities = new ArrayList<>(Arrays.asList("Edward", "How", "Hello", "doing", "are"));
		
		List<String> lst = new ArrayList<>();
		
		for(String val:list) {
			if(cities.contains(val)) {
				lst.add(val);	
			}		
		}
		
		System.out.println(lst);
	}
}
