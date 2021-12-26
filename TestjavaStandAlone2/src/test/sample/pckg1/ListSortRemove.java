package test.sample.pckg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListSortRemove {
	
	List<Integer> lst;
	
	public void addNew(Integer i) {
		
		if(lst.size() <= 3) {
			lst.add(i);
		}else {
			//lst.sort(null);
			lst =lst.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
			//printList(); 
			lst.remove(0);
			lst.add(i);
		}
	}

	public void printList() {
		for(Integer i : lst) {
			System.out.print(i+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String args[]) {
		
		ListSortRemove lsr = new ListSortRemove();
		
		List<Integer> lst = new ArrayList<>(); 

		lsr.lst = lst;
		
		lsr.addNew(4);
		lsr.addNew(5);
		lsr.addNew(7);
		lsr.addNew(8);
		lsr.printList();
		lsr.addNew(2);
		lsr.printList();
		lsr.addNew(10);
		lsr.printList();
		

		
		
		
	}

}
