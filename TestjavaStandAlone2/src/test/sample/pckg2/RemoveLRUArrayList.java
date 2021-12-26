package test.sample.pckg2;

import java.util.ArrayList;
import java.util.List;

public class RemoveLRUArrayList {
	
	List<Integer> lst;
	
	public void add(Integer val) {
		
		if(lst.size()<4) {
			this.lst.add(val);
		}else {
			this.lst.remove(0);
			this.lst.add(val);
		}
		
	}
	
	
	public static void main(String args[]) {
		
		RemoveLRUArrayList rral = new RemoveLRUArrayList();
		
		boolean b =5 < 0;
		System.out.println(b);
		
		rral.lst = new ArrayList<>();
		rral.add(2);rral.add(4);
		System.out.println(rral.lst);
		rral.add(3);rral.add(6);
		System.out.println(rral.lst);
		rral.add(8);
		System.out.println(rral.lst);
		rral.add(7);
		System.out.println(rral.lst);
		
		
		
	}

}
