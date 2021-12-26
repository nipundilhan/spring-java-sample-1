package test.sample.pckg4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irr4 {
	
	
	public static void main(String args[]) {
		
		Irr4 irr= new Irr4();
		
		String finalSolution = "";
		
		double amount = 200000.00;
		double installment = 10012.29;
		int period = 24;
		int repaymentFrequency = 12;
		
		System.out.println(" ");
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(amount),BigDecimal.valueOf(installment),period,repaymentFrequency);
		
		
		System.out.println(" ");
		System.out.println("================= FINAL RESULT ======================================================");
		System.out.println(" ");
		
		System.out.println(" amount = "+ amount +" | installment = "+ installment +" | period = "+ period +" |------|----->  irr = " +finalSolution);
		
		System.out.println(" ");
		System.out.println("======================================================================================");
		System.out.println(" ");

		
		
	}

	
	
	
	private static final int roundOffValue = 40;
	

	public String calculateIrr(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , int repaymentFrequency) {
		
		int initialGuessIrrInt = 12;
		BigDecimal initialGuessIrr = BigDecimal.valueOf(0.00); // 12/repayment_frequency
		BigDecimal npv = calculateNpv(installment,1,loanPeriod,initialGuessIrr);
		

		System.out.println(" ");
		
		BigDecimal finalAnswer = BigDecimal.ZERO;
		
		if(npv.compareTo(loanAmount) >= 0) {
						
//			BigDecimal calculateUpToNoneDigit = iteration1( loanAmount, installment, loanPeriod);			
//			calculateUpToTwoDigit = iteration(loanAmount,installment,loanPeriod,calculateUpToNoneDigit,4);
			
			int noOfIterations = 10;
			int currentIteration = 1;
			BigDecimal guess = BigDecimal.ZERO;
			
			while(currentIteration <= noOfIterations) {
				
				System.out.println(" ");
				System.out.println("**** ITERATION -"+ currentIteration + " started ***************************************");

				
				guess = iteration(loanAmount,installment,loanPeriod,guess,currentIteration , repaymentFrequency);				
				currentIteration +=1;
				
				
				System.out.println(" ");
				System.out.println(" ");
				System.out.println("**** ITERATION -"+ (currentIteration-1) + " ended ****************************************** ");
				System.out.println("   | ");
				System.out.println("   | ");
				System.out.println("   | ");
				System.out.println("   | ");
			}
			
			finalAnswer = guess.multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(repaymentFrequency));
			finalAnswer = finalAnswer.setScale(4, RoundingMode.HALF_UP);
			System.out.print("  | up to 4 decimal  "+finalAnswer);
			finalAnswer = finalAnswer.setScale(3, RoundingMode.HALF_UP);
			System.out.print("  | up to 3 decimal  "+finalAnswer);
			finalAnswer = finalAnswer.setScale(2, RoundingMode.HALF_UP);
			System.out.println("  | up to 2 decimal  "+finalAnswer);
			
		
		}
		
		return finalAnswer.toString();
		
		
	}
	
	
	
	public BigDecimal iteration(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess , int upto ,  int repaymentFrequency) {
				
		BigDecimal finalAnswer = BigDecimal.ONE;

		BigDecimal i = guess;
		
		BigDecimal iterationValue = (BigDecimal.ONE).divide(  (BigDecimal.TEN).pow(upto)   );
		
		BigDecimal limit = guess.add(iterationValue.multiply(BigDecimal.TEN));
		
		int start = 1;
		
		
		
		

		System.out.println(" ");
		System.out.println(" iteration value = "+iterationValue + " , limit = " + limit);
		System.out.println(" ");
		System.out.println(" ");
		
		while ((limit).compareTo(i) > 0) {
			BigDecimal tempNpv = calculateNpv(installment, start, loanPeriod, i);

			System.out.println(i.setScale(upto, RoundingMode.FLOOR) + " -> r% value value is = "+ (i.setScale(upto, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(repaymentFrequency)) + " | npv = "+ tempNpv.setScale(2, RoundingMode.FLOOR));

			if (loanAmount.compareTo(tempNpv) >= 0) {
				finalAnswer = i.subtract(iterationValue);
				break;
			}
			finalAnswer = i;
			i = i.add(iterationValue);
		}

		return finalAnswer;
		
	}
	

	
	
	public BigDecimal calculateNpv(BigDecimal installment, int start , int end ,BigDecimal guess  ) {
		
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
