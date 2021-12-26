package test.pkg.thread;
import java.util.Date;

public class ThreadSample {
	
	public static void main(String args[]) {
		
		Date d1 = new Date();
		
		for(int i = 0 ; i <280000 ; i++) {
			System.out.print(2*i+" ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" --------- ");
		System.out.println(" ");
		System.out.println(" ");
		
		Date d2 = new Date();
		
		
		// in milliseconds 
        long difference_In_Time = d2.getTime() - d1.getTime(); 
        
        System.out.println(difference_In_Time);
		
		
	}

}
