import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlphabetRhythum {
	
	public static void main(String args[]) {
		
		ArrayList<String> cities = new ArrayList<>(Arrays.asList("a","b","c","d","e","f","g","h","i","j"));
			
		System.out.println(cities);
		
		int j = 11;
		for (int z = 0; z < (j+1)/2; z = z +1) {
			for (int i = j; i > 2*z+1; i = i - 1) {
				System.out.print("-");
			}
			
			
			for (int i = 0 ; i < z; i = i + 1) {	
				
				System.out.print(cities.get(i));
				System.out.print("-");
			}
			System.out.print(cities.get(z));
			for (int i = z ; i > 0; i = i - 1) {	
				System.out.print("-");
				System.out.print(cities.get(i-1));
				
			}			
			for (int i = j; i > 2*z+1; i = i - 1) {
				System.out.print("-");
			}

			/*
			int mid = (2*(z+1))/2;
			for (int i = 0 ; i < 2*z+1; i = i + 1) {	

				if(i < mid) {
					System.out.print(cities.get(i));
					System.out.print("-");
				} else if(i == mid ) {
					System.out.print(cities.get(mid-2));
					System.out.print("-");
				}else {
					System.out.print(cities.get(2*z-i));
					if(i!=j-1) {
						System.out.print("-");
					}
					
				}								
			}
			
			for (int i = j; i > 2*(z+1); i = i - 1) {
				System.out.print("-");
			}
			*/
			
			System.out.println(" ");			
		}
		
		
		
	}

}
