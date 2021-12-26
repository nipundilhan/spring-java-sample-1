package test.sample.pckg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateString {

	public static void main(String args[]) {
		List<String> lst = new ArrayList<>();
		
		
//		lst.add("hello");lst.add("hi");lst.add("how");lst.add("hi");
//		lst.add("are");lst.add("you");lst.add("hello");lst.add("hi");
		
		
		String CSV = "Hello how are you, how are things going, hello are you doing good";
		String[] values = CSV.split(",");		
		List<String> list = new ArrayList(Arrays.asList(values));
		
		for(String str:list) {
			System.out.println(str);
			String[] split = str.split(" ");
			List<String> tempList = new ArrayList(Arrays.asList(split));	
			lst.addAll(tempList);
		}
		
		
		 HashMap<String, Integer> couple = new HashMap<String, Integer>();
		 System.out.println(lst);
		while(lst.size() != 0) {
			//System.out.println("initial list"+ lst);
			List<Integer> dupIndexs = new ArrayList<>(); 
			String first = lst.get(0);
			for(int i = 0; i < lst.size() ; i++) {
				if(first == lst.get(i)) {
					dupIndexs.add(i);
				}			
			}
			
			//System.out.println("loop is running");
			//System.out.println("duplicate list"+ dupIndexs);
			couple.put(first,dupIndexs.size());		
			Integer minus = 0;
			for(Integer indx:dupIndexs) {		
				
				lst.remove(lst.get(indx-minus));
				minus += 1;
				//System.out.println("items removed list "+lst);
			}
			//System.out.println("final list"+lst);
			
//			if(lst.size() < 2) {
//				break;
//			}
			//break;
		}
		
		for(String i : couple.keySet()) {
			System.out.println("number value : "+ i + "   /    no of occurances : "+ couple.get(i));
		}

	}
}
