package test.sample.pckg2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irr8 {

	public static void main(String args[]) {
		
		Irr8 irr= new Irr8();
		
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
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1020000.00),BigDecimal.valueOf(32601.84),48		,12);
		System.out.println(" 1 ->  amount = 1020000.00 | installment =32601.84  | period = 48 |--------------- | irr = " +finalSolution);
				
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(48583.13),48		,12);
		System.out.println(" 2 ->  amount = 1520000.00 | installment =48583.13  | period = 48 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(55043.46),48		,12);
		System.out.println(" 3 ->  amount = 1520000.00 | installment =55043.46  | period = 48 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(2520000.00),BigDecimal.valueOf(75255.84),60		,12);
		System.out.println(" 4 ->  amount = 2520000.00 | installment =75255.84  | period = 60 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(120000.00),BigDecimal.valueOf(11268.55),12		,12);
		System.out.println(" 5 ->  amount = 120000.00  | installment =11268.55  | period = 12 |--------------- | irr = " +finalSolution);
				
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(520000.00),BigDecimal.valueOf(27655.47),24			,12);
		System.out.println(" 6 ->  amount = 520000.00  | installment =27655.47  | period = 24 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(15020000.00),BigDecimal.valueOf(491454.67),60		,12);
		System.out.println(" 7 ->  amount = 15020000.0 | installment =491454.67 | period = 60 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(25020000.00),BigDecimal.valueOf(938289.76),60		,12);
		System.out.println(" 8 ->  amount = 25020000.0 | installment =938289.76 | period = 60 |--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(7520000.00),BigDecimal.valueOf(252130.18),48		,12);
		System.out.println(" 9 ->  amount = 7520000.0  | installment =252130.18 | period = 48 |--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(770000.00),BigDecimal.valueOf(39912.49),24		,12);
		System.out.println("10 ->  amount = 770000.00  | installment =938289.76 | period = 24 |--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1000000.00),BigDecimal.valueOf(50061.45),24		,12);
		System.out.println("11 ->  amount = 1000000.00 | installment =50061.45  | period = 24 |--------------- | irr = " +finalSolution);
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(100000.00),BigDecimal.valueOf(9111.59),12		,12);
		System.out.println("12 ->  amount = 100000.00  | installment =9111.59   | period = 12 |--------------- | irr = " +finalSolution);
		
		
		//repayment frequency - 52
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("**************** repayment frequency-52********************");
		System.out.println(" ");
		System.out.println(" ");
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(95000.00),BigDecimal.valueOf(8118.70),12	,52);
		System.out.println("13 ->  amount = 95000.00   | installment =8118.70  | period = 12 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(200000.00),BigDecimal.valueOf(17145.48),12	,52);
		System.out.println("14 ->  amount = 200000.00  | installment =17145.48 | period = 12 |--------------- | irr = " +finalSolution);
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1020000.00),BigDecimal.valueOf(44788.48),24		,52);
		System.out.println("15 ->  amount = 1020000.00 | installment =44788.48 | period = 24 |--------------- | irr = " +finalSolution);
	
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(520000.00),BigDecimal.valueOf(22636.60),24		,52);
		System.out.println("16 ->  amount = 520000.00  | installment =22636.60 | period = 24 |--------------  | irr = " +finalSolution);

		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(200000.00),BigDecimal.valueOf(17020.8),12		,52);
		System.out.println("17 ->  amount = 200000.00  | installment =17020.8  | period = 12 |--------------- | irr = " +finalSolution);

		finalSolution = irr.calculateIrr(BigDecimal.valueOf(500000.00),BigDecimal.valueOf(42730.00),12		,52);
		System.out.println("18 ->  amount = 500000.00  | installment =42730.00 | period = 12 |--------------- | irr = " +finalSolution);
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("**************** repayment frequency-3********************");
		System.out.println(" ");
		System.out.println(" ");
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(2520000.00),BigDecimal.valueOf(238180.60),24	,3);
		System.out.println("19 ->  amount = 2520000.00   | installment =238180.6   | period = 24 |--------------- | irr = " +finalSolution);
	
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(75020000.00),BigDecimal.valueOf(5612464.92),60		,3);
		System.out.println("20 ->  amount = 75020000.00  | installment =5612464.92 | period = 60 |--------------- | irr = " +finalSolution);
	
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(100000.00),BigDecimal.valueOf(12286.58),12		,3);
		System.out.println("21 ->  amount = 100000.00    | installment =12286.58   | period = 12 |--------------- | irr = " +finalSolution);
	
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1000000.00),BigDecimal.valueOf(79362.70),24		,3);
		System.out.println("22 ->  amount = 1000000.00   | installment =79362.70   | period = 24 |--------------- | irr = " +finalSolution);
	

		System.out.println(" ");
		System.out.println(" ");
		System.out.println("**************** repayment frequency-4********************");
		System.out.println(" ");
		System.out.println(" ");
		
		
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(200000.00),BigDecimal.valueOf(13803.98),24		,4);
		System.out.println("23 ->  amount = 200000.00   | installment =13803.98   | period = 24 |--------------- | irr = " +finalSolution);
	
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(200000.00),BigDecimal.valueOf(15978.35),24		,4);
		System.out.println("24 ->  amount = 200000.00   | installment =15978.35   | period = 24 |--------------- | irr = " +finalSolution);
			
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

	public BigDecimal calculateIrr(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , int repaymentFrequency) {
		
		int noOfIterations = 8;
		
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
