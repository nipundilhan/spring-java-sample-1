package test.sample.pckg4;

import java.math.BigDecimal;

public class BigDecErr {
	
	public static void main(String args[]) {
		
		BigDecimal val1 = BigDecimal.valueOf(0.02530);
		BigDecimal val2 = BigDecimal.valueOf(0.00001);
		
		System.out.println(val1.subtract(val2));
		
	}

}
