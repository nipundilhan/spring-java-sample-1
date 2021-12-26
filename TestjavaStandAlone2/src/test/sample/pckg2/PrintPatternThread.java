package test.sample.pckg2;

import java.util.Scanner;

class Num extends Thread{
	  String mark;
	  int num;

	  
	 public Num(String mrk, int nm) {
		super();
		this.mark = mrk;
		this.num = nm;
	}


	public void run(){
		for (int j = 1; j < num+1; j++) {
			for (int i = num-j; i > 0; i--) {
				System.out.print(" ");
			}
			for (int i = 0; i < j; i++) {
				System.out.print(mark+" ");
			}
			
			Thread t = Thread.currentThread();
			try {
				System.out.println("");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

public class PrintPatternThread {
	
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream  
		System.out.print("Enter pattern 1 =  ");  
		String symbol1= sc.nextLine();    
		System.out.print("Enter pattern 2 =  ");  
		String symbol2= sc.nextLine(); 
		System.out.print("Enter count = ");  
		int count= sc.nextInt(); 
		
		System.out.println("========== threads are starting pattern =========");
		
		Num obj1 = new Num(symbol1,count);	
		Num obj2 = new Num(symbol2,count);	
		
		obj1.start();

		Thread t = Thread.currentThread();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj2.start();
		
		
	}

}
