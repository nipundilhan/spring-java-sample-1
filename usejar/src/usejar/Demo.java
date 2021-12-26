package usejar;

import com.simplejar.Student;

public class Demo {
	
	public static void main(String args[]) {
		
		Student s = new Student("nipun",10);
		String work = s.work("maths");
		System.out.println(work);
	}

}
