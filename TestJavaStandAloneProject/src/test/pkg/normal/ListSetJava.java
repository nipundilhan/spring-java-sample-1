package test.pkg.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.pkg.streams.Person;

public class ListSetJava {
	
	public static void main(String args[]) {
		
//        List<Integer> list = Arrays.asList(10, 4, 2, 10, 2, 8);
//        Set<Integer> targetSet = new HashSet<>(list);
//        
//        targetSet.forEach(c -> System.out.println(c));
        
        
        List<String> list = new ArrayList<>();
        
        Person p1 = new Person("mike",10,1);
        Person p2 = new Person("tarzan",12,1);
        Person p3 = new Person("athur",11,1);
        Person p4 = new Person("nitil",11,1);
        Person p5 = new Person("athur",11,1);
        Person p6 = new Person("mike",10,1);
        list.add(new Person("mike",10,2).toString());list.add(new Person("tarzan",12,2).toString());list.add(new Person("mike",10,2).toString());//list.add(p4.toString());list.add(p5.toString());list.add(p6.toString());
        
        Set<String> targetSet = new HashSet<>(list);
        targetSet.forEach(c -> System.out.println(c));
	}

}
