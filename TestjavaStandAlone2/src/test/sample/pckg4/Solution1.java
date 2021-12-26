package test.sample.pckg4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public boolean isValid(String s) {
    	List<String> starting = new ArrayList(Arrays.asList("(","[","{")); 
    	List<String> ending = new ArrayList(Arrays.asList(")","]","}")); 
    	String[] split = s.split("");
    	List<String> sysmbolList = new ArrayList(Arrays.asList(split));
    	
    	List<String> stack = new ArrayList<>();
    	
    	if(split.length > 1) {
    		for(int i = 1; i < split.length ; i++) {
    			if(ending.contains(split[i])) {    				
    				int end = ending.indexOf(split[i]);
    				int start = 0;
    				if(stack.size()!=0) {
    					String remove = stack.remove(stack.size()-1);
    					start = starting.indexOf(remove);  
    				}else {
    					return false;
    				}
    				 				
    				if(start != end) {
    					return false;
    				}    				 				
    			}else {
    				stack.add(split[i]);
    			}    			
    		}   		
    	}else {
    		return false;
    	}
    	
    	if(stack.size() == 0) {
    		return true;
    	}else {
    		return false;
    	}
    }
}

class Solution1 {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
	   int change = 0;
	   ListNode latestNode =null;
	   ListNode h =new ListNode();
	   boolean firstTime = true;
	   
	   ListNode curNode1= l1; ListNode curNode2= l2;
       while(curNode1 != null || curNode1 != null ){
    	   
           int val1 = curNode1.val;
           int val2 = curNode2.val;
           int sum = val1+val2+change;
           int nodeval = 0;
           if(sum>10) {
        	   change = sum/10;
        	   nodeval = sum%10;
           }else {
        	   nodeval = sum;
        	   change = 0;
           }
           
           if(firstTime) {
        	   h.val = nodeval;
        	   latestNode = h;
           }else {
        	   ListNode n = new ListNode();
        	   n.val = nodeval;
        	   latestNode.next = n;
        	   
           }
           
           
           
           firstTime = false;
                 
       }
       
       if(change != 0) {
    	   ListNode n = new ListNode();
    	   n.val = change;
    	   latestNode.next = n;
       }
       
       return h;
       
       
       
   }
   
   
   public static void main(String args[]) {
	   List<Employee> employees = new ArrayList<>();
       employees.add(new Employee(1,"John","street 1,"));
       employees.add(new Employee(2,"Frank","Nr. Cosmos,"));
       employees.add(new Employee(3,"Danyy","street 101,Washington DC,"));
       employees.add(new Employee(1,"John","street 1,"));
       employees.add(new Employee(2,"Frank","Nr. Cosmos,"));
       
		List<Employee> list = employees.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1L).map(e -> e.getKey()).collect(Collectors.toList());
       
		
		for(Employee i : list) {
			System.out.println(i.getEmpId()+"==>"+i.getEmpName());
		}
//       employees.stream().collect(Collectors.groupingBy(Function.identity(),
//               Collectors.counting()))
//               .entrySet().stream()
//               .filter(e -> e.getValue() > 1L)
//               .map(e -> e.getKey())
//               .collect(Collectors.toList())
//               .forEach(employee -> System.out.println(employee.getEmpId()+"==>"+employee.getEmpName()));
   }
}