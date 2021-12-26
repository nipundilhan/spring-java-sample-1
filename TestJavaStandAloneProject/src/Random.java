import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Random {
	
	static int[] values = {11,21,13,42,45,16,27,18,29,10,11,12,31,24,72,24,17,27,81,24};
	
	public static void main(String args[]) throws IOException {
		
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        	System.out.println("enter number value : ");
            // Reading data using readLine
            String name = reader.readLine();
            int index = 0;
            for(int v : values) {
            	
            	int parseInt = Integer.parseInt(name);
            	if(v == parseInt) {
            		System.out.println("index of the element is " +index);
            		return;
            	}
            	index +=1;
            	
            	
            }
            
            if(index == 19) {
            	System.out.println("element not available");
            }
		

		
		
		
		
	}

}
