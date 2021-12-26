package test.sample.pckg4;

import java.math.BigDecimal;
import java.math.RoundingMode;

import test.sample.pckg2.Irr8;

public class Irr8PrePayments {

	public static void main(String args[]) {
		
		Irr8PrePayments irr= new Irr8PrePayments();
		
		BigDecimal finalSolution = BigDecimal.ONE;
		

		System.out.println(" mandatory assumption installment amount is fixed ");
		System.out.println(" only test for repayment frequency 3,4,12,52 ");
		System.out.println(" ");
		System.out.println("================= FINAL RESULTS ==========================");

		
		//repayment frequency - 12
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("**************** repayment frequency-12********************");
		System.out.println(" ");
		System.out.println(" ");
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1000000.00),BigDecimal.valueOf(50329.02),24 ,12,3);
		System.out.println(" 1 ->  amount = 1000000.00 | installment =50329.02  | period = 24 |--------------- | irr = " +finalSolution);
				
		
		System.out.println(" ");
		System.out.println("===========================================");
		System.out.println(" ");
		
	}
	
	public BigDecimal finalCeiling(BigDecimal value) {
		
		BigDecimal finValue = value.setScale(3, RoundingMode.CEILING);
		System.out.println(finValue);
		finValue = finValue.setScale(roundOffValue2, RoundingMode.HALF_EVEN);
		return finValue;
	}

	
	
	
	private static final int roundOffValue = 40;
	private static final int roundOffValue2 = 2;
	private static final int roundOffValue4 = 5;

	public BigDecimal calculateIrr(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , int repaymentFrequency , int noOfPrePayments) {
		
		int noOfIterations = 10;
		
		BigDecimal finalAnswer = BigDecimal.ZERO;
		BigDecimal initialGuessR = BigDecimal.valueOf(0.00); 
		
		int period = loanPeriod-noOfPrePayments;
		BigDecimal amount = loanAmount.subtract(installment.multiply(BigDecimal.valueOf(noOfPrePayments)));
		
		BigDecimal npv = calculateNpv(installment,1,period,initialGuessR);
		
		
		if(npv.compareTo(amount) >= 0) {
									
			int currentIteration = 1;
			BigDecimal guess = BigDecimal.ZERO;
			
			while(currentIteration <= noOfIterations) {
								
				guess = iteration(amount,installment,period,guess,currentIteration);				
				currentIteration +=1;
				
			}
			
			finalAnswer = guess.multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(repaymentFrequency));
//			System.out.println(" ");
//			System.out.print("with out round off "+finalAnswer );
//			finalAnswer = finalAnswer.setScale(2, RoundingMode.HALF_UP);
//			System.out.println("  | up to 2 decimal  "+finalAnswer);
				
		}
		
		return finalAnswer;		
	}
	
	
	
	
	public BigDecimal iteration(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess , int upto) {
				
		BigDecimal finalAnswer = BigDecimal.ONE;
		int start = 1;
		
		
		BigDecimal i = guess;
		
		BigDecimal iterationValue = (BigDecimal.ONE).divide(  (BigDecimal.TEN).pow(upto)   );
		
		BigDecimal limit = guess.add(iterationValue.multiply(BigDecimal.TEN));
		
				
		while ((limit).compareTo(i) > 0) {
			
			BigDecimal tempNpv = calculateNpv(installment, start, loanPeriod, i);

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
				
			npv = npv.add(tempNpv);						
		}
		
		return npv;
	}
}
