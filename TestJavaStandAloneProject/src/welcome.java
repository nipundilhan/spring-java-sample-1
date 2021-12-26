import java.util.ArrayList;
import java.util.Arrays;

public class welcome {
	
	public static void main(String args[]) {
		
		
		int j = 13;
		for (int z = 0; z < ((j+1)/2)-1; z = z +1) {
			printComman(j , z);	
		}
		int mid = ((3*j-7))/2;
		for (int i = 0; i < (3*j-7)+1 ; i = i + 1) {			
			if(i < mid) {
				System.out.print("-");
			}else if(mid == i) {
				System.out.print("welcome");
			}else {
				System.out.print("-");
			}
		}
		System.out.println("");
		
		for (int z = ((j+1)/2)-1; z > -1; z = z - 1) {
			printComman(j , z);			
		}
		
	}
		


    public static void printComman(int j , int z) {
	
	for (int i = 0; i < (3*j-3*(2*z+1))/2; i = i + 1) {
		System.out.print("-");
	}
	for (int i = 0; i < z+1; i = i + 1) {
		System.out.print(".|.");
	}
	for (int i = 0; i < z; i = i + 1) {
		System.out.print(".|.");
	}
	for (int i = 0; i < (3*j-3*(2*z+1))/2; i = i + 1) {
		System.out.print("-");
	}
	System.out.println(" ");
}
}
