package test.sample.pckg3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import test.sample.pckg1.Item;
import test.sample.pckg1.StackExp;

class Item1 {
	
	public String value;
	public int index;

}


public class Parenthesis {
	
	
	int top = -1;
	List<Item1> stack;
	
	public void push(String val,int indx) {
		Item1 itm = new Item1();
		itm.value = val;
		itm.index = indx;
		stack.add(itm);
		
		top += 1;
		
	}
	
	public Item1 pop() {
		Item1 remove = stack.remove(top);
		top -= 1;
		return remove;
	}
	
	public void printStack() {
		for(Item1 i : stack) {
			System.out.print(i.value+" ");
		}
		System.out.println(" ");
	}
	
	public void printStackIndex() {
		for(Item1 i : stack) {
			System.out.print(i.index+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String args[]) {
		
		Parenthesis stexp = new Parenthesis();
		List<Item1> stcklst = new ArrayList<>();
		stexp.stack = stcklst;
		
		String[] split = "(((3+5)*4)+1".split("(?!^)");
		//System.out.println(split);
		
		List<String> list = Arrays.asList(split); 
		//System.out.println(split);
		
		
		List<String> Symbols = Arrays.asList("(", ")");
		int ind =1;
		for(String i : list) {
			ind += 1;
			if(Symbols.contains(i)) {
				if((i).equals("(") ) {
					stexp.push(i,ind);
				}else {
					Item1 pop = stexp.pop();
					System.out.println(i + " in index "+ind + " match with "+ pop.value + " in index "+ + pop.index);
				}
			}
		}
		
		
		if(!(stexp.stack).isEmpty()){
			for(Item1 m : stexp.stack) {
				System.out.println(m.value + " in index " + m.index + " dont have any match");
			}
			
		}


		

		
		
		
	}

}
