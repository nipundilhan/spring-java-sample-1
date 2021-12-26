package test.sample.pckg4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Irr12 {
	
	
	
	
	public static void main(String args[]) {
		
		
		
		List<PeriodAmount> payList = new ArrayList<>();
		
		PeriodAmount pa1 = new PeriodAmount(5,BigDecimal.valueOf(15000.00));
		PeriodAmount pa2 = new PeriodAmount(6,BigDecimal.valueOf(20000.00));
		PeriodAmount pa3 = new PeriodAmount(12,BigDecimal.valueOf(97026.79));
		
		payList.add(pa1);payList.add(pa2);payList.add(pa3);
		
//		Map<String, BigDecimal> paymentList = new HashMap<>();
//		paymentList.put("5",BigDecimal.valueOf(15000.00));
//		paymentList.put("6",BigDecimal.valueOf(20000.00));
//		paymentList.put("12",BigDecimal.valueOf(97026.79));
//		
//		
//        for (Map.Entry<String,BigDecimal> entry : paymentList.entrySet()){
//		    int period = Integer.parseInt(entry.getKey());
//		    System.out.println(period);
//        }	
		
		Irr12 irr= new Irr12();
		

		
	
		String finalSolution = "";
		
		double amount = 985000.00;
		double installment = 97026.79;
		int period = 24;
		int repaymentFrequency = 12;
		
		System.out.println(" ");
		
		
		finalSolution = irr.calculateIrrStructredInstallments(BigDecimal.valueOf(amount), payList ,repaymentFrequency);
		
	
		
		

		
		System.out.println(" ");
		System.out.println("================= FINAL RESULT ======================================================");
		System.out.println(" ");
		
		System.out.println(" amount = "+ amount +" | installment = "+ installment +" | period = "+ period +" |------|----->  irr = " +finalSolution);
		
		
		
		BigDecimal npv1 = irr.calculateNpvStructed(BigDecimal.valueOf(15000.00), 1, 5, BigDecimal.valueOf(0.02833));
		BigDecimal npv2 =irr.calculateNpvStructed(BigDecimal.valueOf(20000.00), 6, 11, BigDecimal.valueOf(0.02833));
		BigDecimal npv3 =irr.calculateNpvStructed(BigDecimal.valueOf(97026.79), 12, 23, BigDecimal.valueOf(0.02833));
		
//		BigDecimal finalNpv =irr.intermediate(payList,BigDecimal.valueOf(0.00284));

		BigDecimal finalNpv = npv1.add(npv2).add(npv3);
		System.out.println(" npv is -"+finalNpv);
		
		System.out.println(" ");
		System.out.println("======================================================================================");
		System.out.println(" ");


		
		
	}

	
	
	
	private static final int roundOffValue = 40;
	
	public String calculateIrrStructredInstallments(BigDecimal loanAmount,List<PeriodAmount> payList , int repaymentFrequency) {
		

		int initialGuessIrrInt = 12;
		BigDecimal initialGuessIrr = BigDecimal.valueOf(0.00); // 12/repayment_frequency

		System.out.println(" ");
		
		BigDecimal finalAnswer = BigDecimal.ZERO;
		

						
//			BigDecimal calculateUpToNoneDigit = iteration1( loanAmount, installment, loanPeriod);			
//			calculateUpToTwoDigit = iteration(loanAmount,installment,loanPeriod,calculateUpToNoneDigit,4);
			
		int noOfIterations = 4;
		int currentIteration = 1;
		BigDecimal guess = BigDecimal.ZERO;

		while (currentIteration <= noOfIterations) {

			System.out.println(" ");
			System.out.println(
					"**** ITERATION -" + currentIteration + " started ***************************************");

			guess = iterationStructred(loanAmount, payList, guess, currentIteration, repaymentFrequency);
			currentIteration += 1;

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(
					"**** ITERATION -" + (currentIteration - 1) + " ended ****************************************** ");
			System.out.println("   | ");
			System.out.println("   | ");
			System.out.println("   | ");
			System.out.println("   | ");
		}

		finalAnswer = guess.multiply(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(repaymentFrequency));
		finalAnswer = finalAnswer.setScale(4, RoundingMode.HALF_UP);
		System.out.print("  | up to 4 decimal  " + finalAnswer);
		finalAnswer = finalAnswer.setScale(3, RoundingMode.HALF_UP);
		System.out.print("  | up to 3 decimal  " + finalAnswer);
		finalAnswer = finalAnswer.setScale(2, RoundingMode.HALF_UP);
		System.out.println("  | up to 2 decimal  " + finalAnswer);
		
		return finalAnswer.toString();
		
		
	}
	

	
	
	
	public BigDecimal iterationStructred(BigDecimal loanAmount,List<PeriodAmount> payList, BigDecimal guess , int upto ,  int repaymentFrequency) {
		
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
			BigDecimal tempNpv = intermediate(payList, i);

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
	
	
	public BigDecimal intermediate(List<PeriodAmount> payList,BigDecimal guess) {
		
		int start= 0;
		BigDecimal finalNpv =BigDecimal.ZERO;
		
        for (PeriodAmount entry : payList){
		    int period = entry.period;
		    int end = start+period;
		    
		    BigDecimal tempNpv = calculateNpvStructed(entry.amount,start,end,guess);
		    finalNpv = finalNpv.add(tempNpv);
		    
		    start = end;
        }		
		return  finalNpv;
	}
	
	public BigDecimal calculateNpvStructed(BigDecimal installment, int start , int end ,BigDecimal guess  ) {
		
		BigDecimal divisor = (BigDecimal.ONE).add((guess));
		BigDecimal npvPeriod = BigDecimal.ZERO;
		for(int i  = start ; i < end+1 ; i++) {
			
			BigDecimal divisorFinal =  divisor.pow(i);
			BigDecimal tempNpv = installment.divide(divisorFinal,roundOffValue,RoundingMode.HALF_EVEN);
			
			
			//System.out.println(" guess = "+guess +" | period = "+i + " | divisor final = "+divisorFinal.setScale(4, RoundingMode.HALF_EVEN) +" | temp npv = "+ tempNpv.setScale(4, RoundingMode.HALF_EVEN) +" | total npv = "+ npv.setScale(4, RoundingMode.HALF_EVEN));
			
			npvPeriod = npvPeriod.add(tempNpv);
						
		}
		
		return npvPeriod;
	}
	

}


class PeriodAmount{
	
	public  int period;
	public BigDecimal amount;
	public PeriodAmount(int period, BigDecimal amount) {
		super();
		this.period = period;
		this.amount = amount;
	}
	
	
	
}
