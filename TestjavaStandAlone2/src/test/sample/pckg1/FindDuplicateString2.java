
package test.sample.pckg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateString2 {

	public static void main(String args[]) {
		List<String> lst = new ArrayList<>();
		

		
		String CSV = "Hello how are you, how are things going, hello are you doing good";
		String[] values = CSV.split(",");		
		List<String> list = new ArrayList(Arrays.asList(values));
		
		for(String str:list) {
			String[] split = str.split(" ");
			List<String> tempList = new ArrayList(Arrays.asList(split));	
			lst.addAll(tempList);
		}
		
		
		 HashMap<String, Integer> couple = new HashMap<String, Integer>();
		 System.out.println(lst);
		 boolean firstOccurence =  false;
		 String firstOccurenceValue = null;
//		while(lst.size() != 0) {
			while(!lst.isEmpty()) {
			

			List<Integer> dupIndexs = new ArrayList<>(); 
			String first = lst.get(0);
			for(int i = 0; i < lst.size() ; i++) {
				if((first.toLowerCase()).equals(lst.get(i).toLowerCase())) {
					dupIndexs.add(i);
				}			
			}

			System.out.println("word - "+ first + " |  no of occurances - "+ dupIndexs.size());
			if((dupIndexs.size() == 1) && firstOccurence ==  false) {
				 firstOccurence =  true;
				 firstOccurenceValue = first;
			}
			
			
			couple.put(first,dupIndexs.size());		
			Integer minus = 0;
			for(Integer indx:dupIndexs) {		
				
				lst.remove(lst.get(indx-minus));
				minus += 1;

			}
			
			
			
		}
		
		System.out.println(lst);
		if(firstOccurence == true) {
			System.out.println("the answer is - "+firstOccurenceValue );
		}else {
			System.out.println("no answer" );
		}


	}
}

