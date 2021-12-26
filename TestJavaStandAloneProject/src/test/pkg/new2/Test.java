package test.pkg.new2;

public class Test {
	
	
	public static void main(String args[]) {
		
		int[] input = { 2, 5 , 6, 20, 4, 7};
		
		//int[] input = { 2, 2 , 2, 2, 2,2};
		//int[] input = { 7, 2 , 2, 2, 2,2};
		
		int largestOne = input[0];
		int largestSecond = -1;
		
		boolean secondFind = false;
		for(int i = 0;i< input.length ; i++) {
						
			if(input[i]>largestOne) {

				largestSecond = largestOne;
				
				largestOne = input[i];
				
				secondFind = true;
				
				
			}	
			if((input[i]<largestOne)    && (input[i]>largestSecond)) {
				largestSecond = input[i];
			}
			
			if(!secondFind) {
				largestSecond = input[input.length-1];
			}
			
		}
		
		
		
		
		System.out.println("second largst is - "+largestSecond);
		
	}

}
