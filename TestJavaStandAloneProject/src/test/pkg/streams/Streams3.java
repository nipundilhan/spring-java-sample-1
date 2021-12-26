package test.pkg.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams3 {
	
	public static void main(String args[]) {
		
        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        list = list.stream()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        
        list.forEach(c -> System.out.println(c));
        
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
          someNumbers.stream()
                     .map(x -> x * x)
                     .filter(x -> x % 3 == 0)
                     .findFirst();
        
        List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
        
        List<Integer> listOfIntegers = listOfStrings.stream()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
        
        List<Integer> squareNumbers = someNumbers.stream().map(x -> x * x).collect(Collectors.toList());
        
       
        
        
        
        List<String> lists = Arrays.asList("geeks", "gfg", "g",
                "e", "e", "k", "s");

        // Using Stream map(Function mapper) to
        	// convert the Strings in stream to
        // UpperCase form
        List<String> answer = lists.stream().map(String::toUpperCase).
        		collect(Collectors.toList());
	}

}
