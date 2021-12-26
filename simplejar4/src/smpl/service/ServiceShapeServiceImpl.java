package smpl.service;

public class ServiceShapeServiceImpl implements ServiceShapeService{
	
	public String shapedraw(String shape) {
		
		DecideShape decideShape =  new DecideShape();
		Shape shapeObj = decideShape.getShape(shape);
		return shapeObj.draw();
	}

}
