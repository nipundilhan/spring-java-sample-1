package smpl.srvc;


public class WorkServiceImpl implements WorkService {
	
	private String defaultWork =  "HR work";
	
	public String getDefaultWork() {
		return defaultWork;
	}
	
	
	public String work1(String wrk) {
		System.out.println("logic is going to execute");
		String result = "this is the work"+wrk;
		return result;
	}
	
	public String work2() {
		System.out.println("logic is going to execute");
		String result = "default work"+defaultWork;
		return result;
	}
	
	private String Work3() {
		return "confidential implementation";
	}



}
