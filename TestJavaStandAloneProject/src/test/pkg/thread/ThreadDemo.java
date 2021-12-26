package test.pkg.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Hello extends Thread{
	  List<Integer> list;
	  List<Integer> listantima = new ArrayList<>();
	  
	  Hello(List<Integer> lt){
		  this.list = lt;
	  }
	  
	  public void run()
	  {
		  int i = 0;
		  for(Integer a : list) {
			  	Thread t = Thread.currentThread();
				System.out.println("thread id- " + t.getId() +" value " +2*a);
				listantima.add( 2*a);
				i += 1;
				try { Thread.sleep(999); } catch (Exception e) {}
		}		
	  }
}


public class ThreadDemo {
	
	public static void main(String args[]) {
		
		Date d1 = new Date();
		
		List<Integer> listFinal = new ArrayList<>();
		
		/*
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		Hello obj1 = new Hello(list);		
		List<Integer> list1 = Arrays.asList(7,8,9,10,11,12);
		Hello obj2 = new Hello(list1);		
		obj1.start();		
		obj2.start();
		
		try {
			Thread.sleep(5999);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	Thread t = Thread.currentThread();
		System.out.println("thread id- " + t.getId() +" main programme " );
		System.out.println("------------");
		listFinal.addAll(obj1.listantima);
		listFinal.addAll(obj2.listantima);
		*/
		
		
		List<Integer> list1 = Arrays.asList(1,2,3);
		Hello obj1 = new Hello(list1);		
		List<Integer> list2 = Arrays.asList(4,5,6);
		Hello obj2 = new Hello(list2);	
		List<Integer> list3 = Arrays.asList(7,8,9);
		Hello obj3 = new Hello(list3);		
		List<Integer> list4 = Arrays.asList(10,11,12);
		Hello obj4 = new Hello(list4);	
		
		obj1.start();		
		obj2.start();
		obj3.start();		
		obj4.start();
		
		try {
			Thread.sleep(2997);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("------------");
		listFinal.addAll(obj1.listantima);
		listFinal.addAll(obj2.listantima);
		listFinal.addAll(obj3.listantima);
		listFinal.addAll(obj4.listantima);
		
		
		System.out.println(listFinal);
		
		Date d2 = new Date();		
		// in milliseconds 
        long difference_In_Time = d2.getTime() - d1.getTime(); 
        
        System.out.println(difference_In_Time);
		
		
		
		
	}

}

