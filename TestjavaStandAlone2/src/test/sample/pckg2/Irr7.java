package test.sample.pckg2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irr7 {

	public static void main(String args[]) {
		
		Irr7 irr= new Irr7();
		
		String finalSolution = "";
		

		System.out.println(" tempory assumption repayment frequency - 12 ");
		System.out.println(" mandatory assumption installment amount is fixed ");
		System.out.println(" ");
		System.out.println("================= FINAL RESULTS ==========================");
		System.out.println(" ");
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1020000.00),BigDecimal.valueOf(32601.84),48);
		System.out.println(" 1 ->  amount = 1020000.00 | installment =32601.84 | period = 48 |--------------- | irr = " +finalSolution);
				
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(48583.13),48);
		System.out.println(" 2 ->  amount = 1520000.00 | installment =48583.13 | period = 48 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(55043.46),48);
		System.out.println(" 3 ->  amount = 1520000.00 | installment =55043.46 | period = 48 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(2520000.00),BigDecimal.valueOf(75255.84),60);
		System.out.println(" 4 ->  amount = 2520000.00 | installment =75255.84 | period = 60 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(120000.00),BigDecimal.valueOf(11268.55),12);
		System.out.println(" 5 ->  amount =  120000.00 | installment =11268.55 | period = 12 |--------------- | irr = " +finalSolution);
				
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(520000.00),BigDecimal.valueOf(27655.47),24);
		System.out.println(" 6 ->   amount = 520000.00 | installment =27655.47 | period = 24 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(15020000.00),BigDecimal.valueOf(491454.67),60);
		System.out.println(" 7 -> amount = 15020000.00 | installment =491454.67 | period = 60|--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(25020000.00),BigDecimal.valueOf(938289.76),60);
		System.out.println(" 8 -> amount = 25020000.00 | installment =938289.76 | period = 60|--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(7520000.00),BigDecimal.valueOf(252130.18),48);
		System.out.println(" 9 -> amount = 7520000.00  | installment =252130.18 | period = 48|--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(770000.00),BigDecimal.valueOf(39912.49),24);
		System.out.println("10 ->  amount = 770000.00  | installment =938289.76 | period = 24|--------------- | irr = " +finalSolution);
		
		
		
		System.out.println(" ");
		System.out.println("===========================================");
		System.out.println(" ");

		
		
	}

	
	
	
	private static final int roundOffValue = 40;
	private static final int roundOffValue2 = 2;
	

	public String calculateIrr(BigDecimal loanAmount,BigDecimal installment, int loanPeriod) {
		
		int noOfIterations = 6;
		int repaymentFrequency = 12;
		
		BigDecimal finalAnswer = BigDecimal.ZERO;
		BigDecimal initialGuessR = BigDecimal.valueOf(0.00); 
		
		BigDecimal npv = calculateNpv(installment,1,loanPeriod,initialGuessR);
		
		
		if(npv.compareTo(loanAmount) >= 0) {
									
			int currentIteration = 1;
			BigDecimal guess = BigDecimal.ZERO;
			
			while(currentIteration <= noOfIterations) {
								
				guess = iteration(loanAmount,installment,loanPeriod,guess,currentIteration);				
				currentIteration +=1;
				
			}
			
			finalAnswer = guess.multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(repaymentFrequency));
			finalAnswer = finalAnswer.setScale(roundOffValue2, RoundingMode.CEILING);
				
		}
		
		return finalAnswer.toString();		
	}
	
	
	
	public BigDecimal iteration(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess , int upto) {
				
		BigDecimal finalAnswer = BigDecimal.ONE;
		int start = 1;
		
		
		BigDecimal i = guess;
		
		BigDecimal iterationValue = (BigDecimal.ONE).divide(  (BigDecimal.TEN).pow(upto)   );
		
		BigDecimal limit = guess.add(iterationValue.multiply(BigDecimal.TEN));
		
				
		while ((limit).compareTo(i) > 0) {
			
			BigDecimal tempNpv = calculateNpv(installment, start, loanPeriod, i);

			//System.out.println(i.setScale(6, RoundingMode.FLOOR) + " -> r% value value is = "+ (i.setScale(6, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv = "+ tempNpv.setScale(2, RoundingMode.FLOOR));

			if (loanAmount.compareTo(tempNpv) >= 0) {
				finalAnswer = i.subtract(iterationValue);
				break;
			}
			finalAnswer = i;
			i = i.add(iterationValue);
		}

		return finalAnswer;
		
	}
	

	
	
	public BigDecimal calculateNpv(BigDecimal installment, int start , int end ,BigDecimal guess ) {
		
		BigDecimal divisor = (BigDecimal.ONE).add((guess));
		BigDecimal npv = BigDecimal.ZERO;
		for(int i  = start ; i < end+1 ; i++) {
			
			BigDecimal divisorFinal =  divisor.pow(i);
			BigDecimal tempNpv = installment.divide(divisorFinal,roundOffValue,RoundingMode.HALF_EVEN);
			
			
			//System.out.println(" guess = "+guess +" | period = "+i + " | divisor final = "+divisorFinal.setScale(4, RoundingMode.HALF_EVEN) +" | temp npv = "+ tempNpv.setScale(4, RoundingMode.HALF_EVEN) +" | total npv = "+ npv.setScale(4, RoundingMode.HALF_EVEN));
			
			npv = npv.add(tempNpv);
						
		}
		
		return npv;
	}
}
