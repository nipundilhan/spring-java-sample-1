
public class TestStarMainJava {

	public static void main(String args[]) {
		

		
		int x = 2;
		while (x < 8) {
			int z = 0;
			while (z < x) {
				int i = 0;
				System.out.println("+");
				while (i < x) {
					int j = 0;
					while (j < x) {
						System.out.print("*");
						j = j + 1;
					}
					System.out.println("");
					i = i + 1;
				}
			
				z = z + 1;
				
			}
			System.out.println("----------------------------");
			x = x+1;

			
		}
	}
}
