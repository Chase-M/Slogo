package features;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;



public class Pen extends GraphicObject{
	
	private double penX;
	private double penY;
	private double penWidth;
	private double turtleWidth;
	private double turtleHeight;
	public double middleX;
	public double middleY;
	private Color penColor;
	
	
	public Pen(){
		penWidth = 1;
		penColor = Color.BLACK;
		middleX = 275;
		middleY = 200;
		penX = middleX;
		penY = middleY;	
		
	}
	public Line drawLine(double x, double y, double tWidth, double tHeight){
		
		System.out.println("drawn");
		
		Line line = new Line();		
		line.setStroke(penColor);		
		line.setStrokeWidth(penWidth);		
		line.setStartX(penX+(tWidth/2));		
		line.setStartY(penY+(tHeight/2));		
		line.setEndX(middleX+x+(tWidth/2));		
		line.setEndY(middleY-y+(tHeight/2));		
		//default pen width is 1
		
		penX = middleX+x;		
		penY = middleY-y;		
		return line;
		
	}
	
	
	public void updatePenColor(Color color){
		// what sort of colour information is backend going to send?
		penColor = color;
	}
	
	public void updatePenWidth(double width){
		//default is 1	
		penWidth = width;
		System.out.println("PenWidth is:" +width);
	}

	public Color returnPenColor(){
		return penColor;
	}
	
	
	@Override
	public void update() {
		
		
		
	}

}
