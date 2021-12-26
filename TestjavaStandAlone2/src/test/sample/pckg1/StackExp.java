package test.sample.pckg1;

import java.util.ArrayList;
import java.util.List;

public class StackExp {
	
	int top = -1;
	List<Item> stack;
	
	public void push(int val) {
		Item itm = new Item();
		itm.value = val; 
		stack.add(itm);
		
		top += 1;
		
	}
	
	public void pop() {
		stack.remove(top);
		top -= 1;
	}
	
	public void printStack() {
		for(Item i : stack) {
			System.out.print(i.value+" ");
		}
		System.out.println(" ");
	}
	
	public static void main(String args[]) {
		
		StackExp stexp = new StackExp();
		List<Item> stcklst = new ArrayList<>();
		stexp.stack = stcklst;
		
		stexp.push(2);
		stexp.push(6);
		stexp.push(8);
		stexp.push(4);
		stexp.push(10);
		stexp.printStack();
		stexp.pop();
		stexp.printStack();
		stexp.push(5);
		stexp.push(3);
		stexp.push(10);
		stexp.printStack();
		stexp.pop();
		stexp.pop();
		stexp.printStack();
		
		
	}
	
	

}
