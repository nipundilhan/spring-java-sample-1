package test.sample.pckg3;

class SunnyDay extends Thread{
	
	  public void run()
	  {
		  System.out.println("it is sunny day");	
		  System.out.println("end of sunny day");
	  }
}

class RainnyDay extends Thread{
	
	  public void run()
	  {
		  System.out.println("it is rainny day");	
		  System.out.println("end of rainny day");
	  }
}

class DisplayWeatherCondition extends Thread{
	
	  public void run()
	  {
		  System.out.println("next day started");
	  }
}

public class MyMain{
	
	public static void main(String args[]) {
		
		SunnyDay t1 = new SunnyDay();
		RainnyDay t2 = new RainnyDay();
		DisplayWeatherCondition t3 = new DisplayWeatherCondition();
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
