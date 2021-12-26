package test.pkg.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams2 {
	
	public static void main(String args[]) {
		

		List<Person> persons = Arrays.asList(
				new Person("Max", 18,1),new Person("Peter", 23,2),new Person("Pamela", 23,1),new Person("David", 18,1));
	
		Map<Integer, List<Person>> personsByAge = persons.stream()
			    .collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
		
		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
		System.out.println(averageAge); 
		
		IntSummaryStatistics ageSummary =
			    persons.stream().collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSummary);
		
		String phrase = persons.stream().map(p -> p.name)
			    .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
		System.out.println(phrase);
		
		phrase = persons.stream().map(p -> p.name)
			    .collect(Collectors.joining(" , ", "" , ""));

		System.out.println(phrase);
		
		
		
		Map<Integer, String> map = persons.stream()
				.collect(Collectors.toMap( p -> p.age, p -> p.name,(name1, name2) -> name1 + ";" + name2));

		System.out.println(map);
	}

}
