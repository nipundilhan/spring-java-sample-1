package test.sample.pckg.unique;

public class Test2 {
	
	
	public static void main(String args[]) {
		
		int[] lst = {4,2,3,4,3,4,1};
		
		
		int max = lst[0];
		for(int i = 1 ; i < lst.length ; i++) {
			
			if(lst[i] > max) {
				max = lst[i];
			}
			
		}
		
		int occurences = 0;
		for(int i = 0 ; i < lst.length ; i++) {
			
			if(lst[i] == max) {
				occurences++;
			}
			
		}
		
		System.out.println("max occurences number "+ max);
		
		
		
		
		
		
		
	}

}
