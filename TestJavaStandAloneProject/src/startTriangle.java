
public class startTriangle {
	
	public static void main(String args[]) {
		int q = 4;
		for(int i = 0 ; i < q ; i++) {
			
			for(int j = q ; j > i ; j--) {
				System.out.print(" ");
			}
			for(int z = 0 ; z < 2*i+1 ; z++) {
				System.out.print("*");
			}
			System.out.println(" ");
			
		}
		
	}

}
