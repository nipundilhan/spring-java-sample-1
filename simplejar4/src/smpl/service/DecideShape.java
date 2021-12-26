package smpl.service;

public class DecideShape {
	
	   public Shape getShape(String shapeType){
		   
		   
		      if(shapeType == null){
		         return null;
		      }		
		       else if(shapeType.equalsIgnoreCase("REC")){
		         return new Rectangle();
		         
		      } else if(shapeType.equalsIgnoreCase("SQR")){
		         return new Square();
		      }
		      
		      return null;
		   }

}
