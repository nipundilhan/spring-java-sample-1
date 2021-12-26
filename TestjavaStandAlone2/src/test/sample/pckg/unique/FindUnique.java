package test.sample.pckg.unique;

import java.util.HashSet;
import java.util.Set;

public class FindUnique {
	
	public static void main(String args[]) {
		
		Car c1 = new Car("Toyota","white");
		Car c2 = new Car("Toyota","ash");
		Car c3 = new Car("Toyota","white");
		Car c4 = new Car("Nissan","white");
		Car c5 = new Car("Nissan","white");
		Car c6 = new Car("Toyota","red");
		
		
		Set<Car> setVal = new HashSet<>();
		setVal.add(c1); setVal.add(c2); setVal.add(c3);
		setVal.add(c4); setVal.add(c5); setVal.add(c6);
		
		
		setVal.size();
		for(Car cr :setVal) {
			System.out.println(" company - "+ cr.getCompany() + " | colour - "+cr.getColour());
		}
		
		
		

		
	}

}
