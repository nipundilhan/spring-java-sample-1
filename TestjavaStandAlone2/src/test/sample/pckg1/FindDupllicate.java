package test.sample.pckg1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindDupllicate {
	
	
	public static void main(String args[]) {
		 
		 List<Integer> lst = new ArrayList<>(); 
		 lst.add(1);lst.add(2);lst.add(2);lst.add(3);lst.add(4);lst.add(5);lst.add(1);lst.add(1);lst.add(2);lst.add(2);lst.add(3);lst.add(4);
		 
		 HashMap<Integer, Integer> couple = new HashMap<Integer, Integer>();
		 System.out.println(lst);
		while(lst.size() != 0) {
			//System.out.println("initial list"+ lst);
			List<Integer> dupIndexs = new ArrayList<>(); 
			Integer first = lst.get(0);
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
		
		for(Integer i : couple.keySet()) {
			System.out.println("number value : "+ i + "   /    no of occurances : "+ couple.get(i));
		}
			
		 
		 //System.out.println(lst);
		
		
	}

}
