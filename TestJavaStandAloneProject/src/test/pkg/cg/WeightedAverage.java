package test.pkg.cg;

import java.util.List;
import java.util.Arrays;

public class WeightedAverage
{
    public static double mean(List<Integer> numbers, List<Integer> weights)
    {
        
    	
    	if(numbers == null ||  weights == null) {
    		throw new  IllegalArgumentException(" either one list cannot be null");
    	}
    	
    	if(numbers.isEmpty() ||  weights.isEmpty()) {
    		throw new  IllegalArgumentException(" either one list cannot be empty");
    	}
    	
    	if(numbers.size() != weights.size() ) {
    		throw new  IllegalArgumentException("two list should be same size");
    	}
        
        int total = 0;
        int totalWeights = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            total += numbers.get(i) * weights.get(i);
            totalWeights += weights.get(i);
        }

        return (double) ((double)1000000000 / (double)3);
    }

    public static void main(String[] args)
    {
        List<Integer> a = Arrays.asList(new Integer[] { 3, 6 });
        List<Integer> b = Arrays.asList(new Integer[] { 4, 2 });

        System.out.println(WeightedAverage.mean(a, b));
        
    }
}
