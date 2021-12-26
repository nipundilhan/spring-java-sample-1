
public class Vehicle {
	
	public String model = "none";
	
	public String registerNo = "9999";
	
	public void start() {
		System.out.println("vehicle started");		
	}
	
	
	public void changeGear() {		
		System.out.println("gear changed");
	}
	

	
	public static void main(String args[]) {
		
		Vehicle v1 = new Vehicle();
		v1.setModel("Axio");
		Vehicle v2 = new Vehicle();
		v2.changeGear();
		
		
		
		
	}
	
	
	
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getRegisterNo() {
		return registerNo;
	}


	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}


	
}
