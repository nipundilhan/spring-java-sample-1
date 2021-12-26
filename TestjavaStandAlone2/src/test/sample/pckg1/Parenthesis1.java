package test.sample.pckg1;

public class Parenthesis1 {
	
/*	public static void main(String args[]) {
		
		Parenthesis1 ss = new Parenthesis1();
		
//		String exp = "(";
//		String exp = ")";
//		String exp = "(()()";
//		String exp = "(()())";
//		String exp = "(()())()(";
		String exp = "(()())()()";
		
		String[] split = exp.split("");
		
		String[] arr = new String[split.length];
		int top = 0;
		boolean valid = true;
		
		for(int i=0; i < split.length ; i++) {
			
			if(("(").equals(split[i])) {
				arr[top] = "(";
				top = top+1;
			}else if((")").equals(split[i])) {
				if(top > 0) {
					top = top-1;
				}else {
					//extra closing bracket
					valid = false;
				}
			}
			
			
		}
		
		if(valid) {
			if(top == 0) {
				//extra opening bracket
				System.out.println("valid parenthesis ");
			}else {
				System.out.println("invalid parenthesis");
			}
		}else {
			System.out.println("invalid parenthesis");
		}
		
		
	}
*/
	
	public static void main(String args[]) {
		
		Parenthesis1 ss = new Parenthesis1();

		String exp = "abcefg";
		
		String[] split = exp.split("");
		
		String[] stack = new String[split.length];
		int top = 0;
		boolean valid = true;
		
		for(int i=split.length-1; i >-1 ; i--) {
			stack[top] = split[i];
			top = top+1;			
		}
		
		ss.printArray(stack);
		
		
	}
	
	public void printArray(String arry[]) {
		for(int i =0 ; i <arry.length ;i++ ) {
			System.out.print(arry[i]+"  ");
		}
		System.out.println("");
	}

}
