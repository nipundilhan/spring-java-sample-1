package test.pkg.thread;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class Hi extends Thread{
	  List<Integer> list;
	  List<Integer> listantima = new ArrayList<>();
	  
	  Hi(List<Integer> lt){
		  this.list = lt;
	  }
	  
	  public void run()
	  {
		  int i = 0;
		  for(Integer a : list) {
			  	
				System.out.println(2*a);
				listantima.add( 2*a);
				i += 1;
				try { Thread.sleep(999);
				} catch (Exception e) {}
		}		
	  }
}


public class ThreadDemoDup {
	
	public static void main(String args[]) {
		
		Date d1 = new Date();
		
		List<Integer> listFinal = new ArrayList<>();
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
		Hi obj1 = new Hi(list);		
	
		obj1.start();	
		
		try {
			Thread.sleep(11997);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------");
		listFinal.addAll(obj1.listantima);


		
		System.out.println(listFinal);
		
		Date d2 = new Date();		
		// in milliseconds 
        long difference_In_Time = d2.getTime() - d1.getTime(); 
        
        System.out.println("total time "+difference_In_Time);
		
		
		
		
	}

}

