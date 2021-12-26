package test.sample.star;

public class Star1 {
	
	
	public void print1(int val1 , int val2) {
		for (int i = 0; i < val1; i++) {
			for (int j = 0; j < val2; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void print2(int val1) {
		for (int i = 1; i < val1+1; i++) {
			
			for (int j = 0; j < val1-i; j++) {
				System.out.print(" ");
			}
			for (int j = val1; j > val1 - i; j--) {
				System.out.print("*");
			}

			System.out.println(" ");
		}
	}
	
	
	public void print3() {

		int val1 = 6;
		System.out.println("*******");

		for (int j = 0; j < val1 - 2; j++) {
			System.out.print("*");

			for (int i = 0; i < j; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int i = 0; i < (val1 - 2) - j; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println(" ");
		}

		System.out.println("*******");
	}
	
	public void print4() {

		int val1 = 8;
		System.out.println("**********");

		for (int j = 0; j < val1-4 ;j++) {
			System.out.print("*");

			for (int i = 0; i < val1; i++) {
				System.out.print(" ");
			}
			System.out.print("*");
			System.out.println(" ");
		}

		System.out.println("**********");

	}
	
	

	
	public void print5(int val1) {
		for (int i = 0; i < val1; i++) {
			
			for (int j = 0; j < val1-i; j++) {
				System.out.print("*");
			}

			System.out.println(" ");
		}
	}
	
	public void print6(int val1) {
		for (int i = 1; i < val1+1; i++) {
			
			
			for (int j = val1; j > val1 - i; j--) {
				System.out.print("*");
			}

			System.out.println(" ");
		}
	}
	
	
	
	public static void main(String args[]) {
		
		Star1 s1 = new Star1();
		//s1.print1(6,10);
		s1.print3();
		//s1.print5(8);
		
	}

}
