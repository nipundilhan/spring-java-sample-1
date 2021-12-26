package test.pkg.thread;


class Num extends Thread{
	  int num;

	  
	 public Num(int num) {
		super();
		this.num = num;
	}


	public void run()
	  {
		  
		  for(int i = num ; i < num+100 ; i++) {
			  	Thread t = Thread.currentThread();
				System.out.println("thread id- " + t.getId() +" value " +i);

		}		
	  }
}

public class ThreadPrintSequence {
	
	public static void main(String args[]) {
		
		Num obj1 = new Num(0);	
		Num obj2 = new Num(100);	
		
		obj2.start();
		obj1.start();
		
	}

}
