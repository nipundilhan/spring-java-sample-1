import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassMain {

	public static void main(String args[]) {
		
		VehiclePark vp = new VehiclePark();
		
		vp.vehicleList = new ArrayList<>();
		
		// enter vehicle - E
		// calculate price - C
		// print current vehicle list - P
		
		System.out.println("programme started ");	
		System.out.println("   ");
		System.out.println("   ");
		
		Boolean end = false;
		
		while(end != true) {
			Scanner scnr =  new Scanner(System.in);
			
			System.out.print("enter operation - ");	

			
			String operation = scnr.nextLine();
			
			if("end".equals(operation)) {
				end = true;
				System.out.println("programme end ");	
				
			}else {
				
				if("E".equals(operation)) {
					
					Scanner scnr1 =  new Scanner(System.in);					
					System.out.print("enter the model - ");	
					String mdl = scnr1.nextLine();
					
					System.out.print("enter the register no - ");	
					String rgstrNo = scnr1.nextLine();
					
					
					Vehicle vhcl = new Vehicle();
					vhcl.model = mdl;
					vhcl.registerNo = rgstrNo;
					
					vp.vehicleList.add(vhcl);
					
					
					
					System.out.println("   ");
					System.out.println("   ");
					System.out.println("vehicle enterd successfully");
					System.out.println("   ");
					System.out.println("   ");
														
				} else if ("P".equals(operation)) {				
					vp.currentVehicleList();
				} else {
					
					System.out.print("wrong operation re enter ");
				}
				
				

			}
			
			
		}
		
		
		
		
			
	}
}
