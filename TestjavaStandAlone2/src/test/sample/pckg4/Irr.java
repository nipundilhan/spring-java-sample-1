package test.sample.pckg4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irr {
	
	
	public static void main(String args[]) {
		
		Irr irr= new Irr();
		
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

			System.out.println("--start up to one digit ------------------------");
			System.out.println(" ");
			System.out.println(" ");
			
			
			BigDecimal calculateUpToOneDigit =calculateUpToOneDigit(loanAmount,installment,loanPeriod,1,1);
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to one digit --------------------------");
			System.out.println(" ");
			System.out.println("  *************************** ");
			System.out.println(" 	SECOND ITERATION     ");
			System.out.println(" ");
			System.out.println("  *************************** ");
			System.out.println(" ");
			System.out.println("--start up to two digit --------------------------");
			System.out.println(" ");
			
			calculateUpToTwoDigit =calculateUpToTwoDigit(loanAmount,installment,loanPeriod,calculateUpToOneDigit,1);
			
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("--end up to two digit --------------------------");
			
		}
		
		return calculateUpToTwoDigit.toString();
		
		
	}
	
	
	
	public BigDecimal calculateUpToNoneDigit(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , int guess ,int plusMinus) {
		
		
		double moreAccurateIrr = guess;
		
		BigDecimal finalAnswer = BigDecimal.TEN;
		

			BigDecimal i = BigDecimal.valueOf(0.01);

			while((BigDecimal.valueOf(0.1)).compareTo(i) >= 0) {
				BigDecimal tempNpv = calculateNpv(installment,1,loanPeriod,i);
				
				System.out.println(i.setScale(4, RoundingMode.FLOOR)+" -> r% value value is = "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200))+ " | npv = "+tempNpv.setScale(2, RoundingMode.FLOOR));
		
//				
				if(loanAmount.compareTo(tempNpv) >= 0) {
					i = i.subtract(BigDecimal.valueOf(0.01));
					finalAnswer = i;
					break;
				}
				

				
				i = i.add(BigDecimal.valueOf(0.01));
				//i = Double.sum(i, 0.0001d);

			

			
		}
		
		return finalAnswer;
		
	}
	
	
	
	
	
	
	public BigDecimal calculateUpToOneDigit(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , int guess ,int plusMinus) {
		
		
		double moreAccurateIrr = guess;
		
		BigDecimal finalAnswer = BigDecimal.TEN;
		
		if(plusMinus == 1) {
//			double i = 0.0190d;
			BigDecimal i = BigDecimal.valueOf(0.019);

			while((BigDecimal.valueOf(100)).compareTo(i) >= 0) {
				BigDecimal tempNpv = calculateNpv(installment,1,loanPeriod,i);
				
//				System.out.println(" ");
//				System.out.println("----------------start--------------------------");
//				System.out.println(" ");
				System.out.println(i.setScale(4, RoundingMode.FLOOR)+" -> r% value value is = "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200))+ " | npv = "+tempNpv.setScale(2, RoundingMode.FLOOR));
//				System.out.println(" ");
//				System.out.println("-----------------end--------------------------");
//				System.out.println(" ");			
//				
				if(loanAmount.compareTo(tempNpv) >= 0) {
					i = i.subtract(BigDecimal.valueOf(0.001));
//					finalAnswer = i.multiply(BigDecimal.valueOf(1200));
//					finalAnswer = finalAnswer.setScale(1, RoundingMode.CEILING);
					finalAnswer = i;
					break;
				}
				

				
				i = i.add(BigDecimal.valueOf(0.001));
				//i = Double.sum(i, 0.0001d);
			}
			

			
		}
		
		return finalAnswer;
		
	}
	
	
	public BigDecimal calculateUpToTwoDigit(BigDecimal loanAmount,BigDecimal installment, int loanPeriod , BigDecimal guess ,int plusMinus) {
		
		
		BigDecimal finalAnswer = BigDecimal.TEN;
		
		if(plusMinus == 1) {

			BigDecimal i = guess;

			BigDecimal limit  = i.add(BigDecimal.TEN);
			while((limit).compareTo(i) >= 0) {
				BigDecimal tempNpv = calculateNpv(installment,1,loanPeriod,i);
				
//				System.out.println(" ");
//				System.out.println("----------------start--------------------------");
//				System.out.println(" ");
				System.out.println(i.setScale(4, RoundingMode.FLOOR) +" -> r% value is - "+ (i.setScale(4, RoundingMode.FLOOR)).multiply(BigDecimal.valueOf(1200)) + " | npv is "+tempNpv.setScale(2, RoundingMode.FLOOR));
//				System.out.println(" ");
//				System.out.println("-----------------end--------------------------");
//				System.out.println(" ");			
//				
				if(loanAmount.compareTo(tempNpv) >= 0) {
					i = i.subtract(BigDecimal.valueOf(0.0001));
					finalAnswer = i.multiply(BigDecimal.valueOf(1200));
					finalAnswer = finalAnswer.setScale(1, RoundingMode.CEILING);
					break;
				}
				

				
				i = i.add(BigDecimal.valueOf(0.0001));
				//i = Double.sum(i, 0.0001d);
			}
			

			
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
