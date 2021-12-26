package test.pkg.thread;

class Runbl implements Runnable{
	  int num;

	  
	 public Runbl(int num) {
		super();
		this.num = num;
	}


	public void run()
	  {
		  
		  for(int i = num ; i < num+10 ; i++) {
			  	Thread t = Thread.currentThread();
				System.out.println("thread id- " + t.getId() +" value " +i);

		}		
	  }
}


public class Task {
	public static void main(String args[]) {
		
		Runbl obj1 = new Runbl(20);	
		Runbl obj2 = new Runbl(100);	
		
		Thread t1 =new Thread(obj1);   // Using the constructor Thread(Runnable r)  
		t1.start();  
		
		
		Thread t2 =new Thread(obj2);   // Using the constructor Thread(Runnable r)  
		t2.start();  
	}
}
