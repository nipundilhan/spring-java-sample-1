package test.sample.pckg4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irr1 {
	
	
	public static void main(String args[]) {
		
		Irr1 irr= new Irr1();
		
		String finalSolution = "";
//		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1020000.00),BigDecimal.valueOf(32601.84),48);
//		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(48583.13),48);
		finalSolution = irr.calculateIrr(BigDecimal.valueOf(1520000.00),BigDecimal.valueOf(55043.46),48);
//		finalSolution = irr.calculateIrr(BigDecimal.valueOf(2520000.00),BigDecimal.valueOf(75255.84),60);
		
		
		System.out.println(" ");
		System.out.println("===========================================");
		System.out.println(" ");
		System.out.println(" final IRR value  is - "+finalSolution);
		System.out.println(" ");
		System.out.println("===========================================");
		System.out.println(" ");
		
		
	}

	
	
	
	private static final int roundOffValue = 40;
	

	public String calculateIrr(BigDecimal loanAmount,BigDecimal installment, int loanPeriod) {
		
		int initialGuessIrrInt = 12;
		BigDecimal initialGuessIrr = BigDecimal.valueOf(0.01); // 12/repayment_frequency
		BigDecimal npv = calculateNpv(installment,1,loanPeriod,initialGuessIrr);
		
//		System.out.println(" ");
//		System.out.println("--npv ------------------------"+ npv);
//		System.out.println(" ");
		
		BigDecimal calculateUpToTwoDigit = BigDecimal.TEN;
		if(npv.compareTo(loanAmount) >= 0) {
			
			
			System.out.println(" tempory assumption repayment frequency - 12 ");
			System.out.println(" mandatory assumption installment amount is fixed ");
			System.out.println(" ");
			
			System.out.println("************************************************* ");
			System.out.println(" 	1ST ITERATION     ");
			System.out.println(" ");
			System.out.println("************************************************* ");
			
			System.out.println("--start up to NONE digit ------------------------");
			System.out.println(" ");
			System.out.println(" ");			
			
			
			BigDecimal calculateUpToNoneDigit = iteration1( loanAmount, installment, loanPeriod);
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to NONE digit --------------------------");
			System.out.println(" ");
			System.out.println("************************************************* ");
			System.out.println(" 	2ND ITERATION     ");
			System.out.println(" ");
			System.out.println("************************************************* ");
			System.out.println(" ");
			System.out.println("--start up to one digit ------------------------");
			System.out.println(" ");
			System.out.println(" ");
			
			
			BigDecimal calculateUpToOneDigit = iteration2(loanAmount,installment,loanPeriod,calculateUpToNoneDigit);
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to one digit --------------------------");
			System.out.println(" ");
			System.out.println("************************************************* ");
			System.out.println(" 	3RD ITERATION     ");
			System.out.println(" ");
			System.out.println("************************************************* ");
			System.out.println(" ");
			System.out.println("--start up to two digit --------------------------");
			System.out.println(" ");
			
			calculateUpToTwoDigit = iteration3(loanAmount,installment,loanPeriod,calculateUpToOneDigit);
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to two digit --------------------------");
			
			System.out.println("************************************************* ");
			System.out.println(" 	 4TH ITERATION     ");
			System.out.println(" ");
			System.out.println("************************************************* ");
			System.out.println(" ");
			System.out.println("--start up to three digit --------------------------");
			System.out.println(" ");
			
			calculateUpToTwoDigit = iteration4(loanAmount,installment,loanPeriod,calculateUpToTwoDigit);
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to three digit --------------------------");
			
		}
		
		return calculateUpToTwoDigit.toString();
		
		
	}
	
	
	
	public BigDecimal iteration1(BigDecimal loanAmount,BigDecimal installment, int loanPeriod) {
		
		BigDecimal finalAnswer = BigDecimal.ONE;

		BigDecimal i = BigDecimal.valueOf(0.00);

		while ((BigDecimal.valueOf(0.1)).compareTo(i) >= 0) {

			BigDecimal tempNpv = calculateNpv(installment, 1, loanPeriod, i);
			System.out.println(i + " -> r% value value is = "+ (i.setScale(2, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv = "+ tempNpv.setScale(2, RoundingMode.FLOOR));

//				
			if (loanAmount.compareTo(tempNpv) >= 0) {
				i = i.subtract(BigDecimal.valueOf(0.01));
				finalAnswer = i;
				break;
			}

			i = i.add(BigDecimal.valueOf(0.01));

		}
		
		return finalAnswer;
		
	}
	
	
	
	
	
	
	public BigDecimal iteration2(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess) {
		
		

		
		BigDecimal finalAnswer = BigDecimal.ONE;

		BigDecimal i = guess;

		while ((BigDecimal.valueOf(0.1)).compareTo(i) >= 0) {
			BigDecimal tempNpv = calculateNpv(installment, 1, loanPeriod, i);

			System.out.println(i.setScale(4, RoundingMode.FLOOR) + " -> r% value value is = "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv = "+ tempNpv.setScale(2, RoundingMode.FLOOR));

			if (loanAmount.compareTo(tempNpv) >= 0) {
				i = i.subtract(BigDecimal.valueOf(0.001));
				finalAnswer = i;
				break;
			}

			i = i.add(BigDecimal.valueOf(0.001));
		}

		return finalAnswer;
		
	}
	
	
	public BigDecimal iteration3(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess) {
		
		
		BigDecimal finalAnswer = BigDecimal.TEN;

		BigDecimal i = guess;

		BigDecimal limit = i.add(BigDecimal.valueOf(0.1));
		while ((limit).compareTo(i) >= 0) {
			BigDecimal tempNpv = calculateNpv(installment, 1, loanPeriod, i);

			System.out.println(i.setScale(4, RoundingMode.FLOOR) + " -> r% value is - "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv is "+ tempNpv.setScale(2, RoundingMode.FLOOR));
			
			if (loanAmount.compareTo(tempNpv) >= 0) {
				i = i.subtract(BigDecimal.valueOf(0.0001));
				finalAnswer = i;
				break;
			}

			i = i.add(BigDecimal.valueOf(0.0001));
		}

		return finalAnswer;
		
	}
	
	
	public BigDecimal iteration4(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess) {
		
		
		BigDecimal finalAnswer = BigDecimal.TEN;

		BigDecimal i = guess;

		BigDecimal limit = i.add(BigDecimal.valueOf(0.1));
		while ((limit).compareTo(i) >= 0) {
			BigDecimal tempNpv = calculateNpv(installment, 1, loanPeriod, i);

//				System.out.println(" ");
//				System.out.println("----------------start--------------------------");
//				System.out.println(" ");
			System.out.println(i.setScale(5, RoundingMode.FLOOR) + " -> r% value is - "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv is "+ tempNpv.setScale(2, RoundingMode.FLOOR));
//				System.out.println(" ");
//				System.out.println("-----------------end--------------------------");
//				System.out.println(" ");			
//				
			if (loanAmount.compareTo(tempNpv) >= 0) {
				i = i.subtract(BigDecimal.valueOf(0.00001));
				finalAnswer = i.multiply(BigDecimal.valueOf(1200));
				finalAnswer = finalAnswer.setScale(2, RoundingMode.HALF_EVEN);
				break;
			}

			i = i.add(BigDecimal.valueOf(0.00001));
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
