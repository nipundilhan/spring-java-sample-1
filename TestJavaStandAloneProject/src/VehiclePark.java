import java.util.List;

public class VehiclePark {
	
	int carPerHour =  50;
	int bikePerHour = 25;
	
	List<Vehicle> vehicleList;
	
	public void calculatePrice(int hours , String model) {
		
		if("car".equals(model)) {
			System.out.println("cost is - "+ hours * carPerHour );
			
		}else if("bike".equals(model)) {
			System.out.println("cost is - "+ hours * bikePerHour );
			
		}else {
			System.out.println("wrong vehicle model re enter");
		}		
	}
	
	
	public void currentVehicleList() {
		
		System.out.println("  ");
		System.out.println("  ");		
		System.out.println("-------------going to print vehicle list-------------" );
		System.out.println("  ");
		System.out.println("  ");
		
		for(Vehicle vhcl : vehicleList) {
			System.out.println("vehicle model - " + vhcl.model + " register no - " + vhcl.registerNo);

		}
		
		
		System.out.println("  ");
		System.out.println("  ");
		System.out.println("-------------end printing-------------" );
		
	}
		
		
		
}
	
	
	
	


