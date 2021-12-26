package test.sample.pckg4;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
	
	
	public static void main(String args[]) {
		
		Emp e1 = new Emp("AB");
		Emp e2 = new Emp("AB");
		
		if((e1).equals(e2)) {
			System.out.println("object matched");
		}
		
		Set<Emp> employees = new HashSet<Emp>();
		employees.add(e1);
		employees.add(e2);

		System.out.println(employees);	//Prints two objects
		
	}
	

}


class Emp {
	
	String name;

	public Emp(String name) {
		super();
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
