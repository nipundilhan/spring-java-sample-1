package com.example.databaseSample.service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.databaseSample.entity.student;
import com.example.databaseSample.repository.studentRepository;

@Service
public class TestCollectionStreamSampleService1 {
	
	@Autowired
	private studentRepository studentRep;
	
	public List<student> collectionStreamSample1() {
		
		List<student> allStudents = studentRep.findAll();
		List<student> finalList = null;
		
		allStudents.stream().forEach(i -> System.out.print(i.getContactvalue() + " "));
		
		allStudents.forEach(i ->{
									System.out.println(" statement 1 - "+i.getFirstname());
									System.out.println(" statement 2 - "+i.getLastname());
							   	}
							);
		
//		List<String> nameList = Arrays.asList("Hiranya", "Hirasha");
		List<String> nameList =allStudents.stream().map(student::getFirstname).collect(Collectors.toList());
		
		 finalList = allStudents.stream()
			           .filter(e -> nameList.contains(e.getFirstname()))
			           .collect(Collectors.toList());
		
		//finalList = allStudents.stream().filter(n -> n.getGrade() > 10 && n.getFirstname().startsWith("H")  ).collect(Collectors.toList());
		//finalList = allStudents.stream().filter(n -> n.getFirstname().startsWith("han",2)  ).collect(Collectors.toList());	//startsWith(string,offset)
		//finalList = allStudents.stream().filter(n -> n.getFirstname().contains("hi")).collect(Collectors.toList());
		//finalList = allStudents.stream().filter(n -> n.getContactvalue().matches("^(.+)@(.+)$")).collect(Collectors.toList());

		//finalList = allStudents.stream().limit(2).collect(Collectors.toList());
		//finalList = allStudents.stream().skip(1).limit(3).collect(Collectors.toList());
		//finalList = allStudents.stream().skip(2).collect(Collectors.toList());
		
		/*
        finalList = allStudents.stream().sorted(Comparator.comparingLong(student::getGrade))
                .collect(Collectors.toList());
        
        finalList = allStudents.stream().distinct().sorted(Comparator.comparing(student::getFirstname).reversed())
                .collect(Collectors.toList());
        
        
        
        long count = allStudents.stream().distinct()
        		.sorted(Comparator.comparing(student::getFirstname).reversed()).count();
        
        student findFirst1 = allStudents.stream()
                .sorted(Comparator.comparing(student::getFirstname).reversed()).findFirst().orElse(null);
        
        student findFirst2 = allStudents.stream().findFirst().orElse( null);
        
        student minRef = allStudents.stream().max(Comparator.comparing(student::getGrade)).orElse(null);
        
        int sumGrade = allStudents.stream()
        		  .collect(Collectors.summingInt(student::getGrade));
        System.out.println("");
        System.out.println(sumGrade);
        String result = allStudents.stream().map(student::getFirstname).collect(Collectors.joining(","));
        System.out.println(result);
        
        List<String> awesomeAnimals = Arrays.asList("Shark", "Panda", "Armadillo");
        String animalString = awesomeAnimals.stream().collect(Collectors.joining(", "));
        System.out.println(animalString);
        
        */
		return finalList;
		
		
		
		
	}

}
