package test.sample.pckg4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class guess1 {
	
	public void guess() throws IOException {
		
		System.out.println("if yes enter 1 | higher enter 2 | if lower enter 3");
		System.out.println("if higher enter 2 ");
		System.out.println("if lower enter 3 ");
		
		boolean correct=false;
		int min = 0;
		int max =100;
		
		int guess = 50;
		
		
		int attempts = 0;
		

		while(!correct) {
			
			System.out.print("is "+guess+ " in your mind? -  ");
			
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	     
	        // Reading data using readLine
	        String isCorrect = reader.readLine();

	        if( ("1").equals(isCorrect) ) {
	        	correct=true;
	        	attempts = attempts+1;
	        	System.out.println("number of attempts get to guess - "+attempts);
	        }else if(("2").equals(isCorrect) ) {
	        	attempts = attempts+1;
	        	min = guess;
	        	guess = (max + guess);
	        	
	        	if(guess%2 == 0) {
	        		guess = guess/2;
	        	}else {
	        		guess = (guess+1)/2;
	        	}
	        		        	
	        }else if(("3").equals(isCorrect) ) {
	        	attempts = attempts+1;
	        	max = guess;
	        	guess = (min + guess);
	        	
	        	if(guess%2 == 0) {
	        		guess = guess/2;
	        	}else {
	        		guess = (guess+1)/2;
	        	}
	        	
	        	
	        }
	        
	        if(min == max) {
	        	System.out.println("your answer should be "+ guess + "no of attempts get "+ attempts);
	        	break;
	        }
			
		}
		

	}
	
	public static void main(String args[]) {
		
		guess1 g = new guess1();
		try {
			g.guess();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
