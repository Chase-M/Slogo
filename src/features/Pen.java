package features;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;



public class Pen extends GraphicObject{
	
	private double penX;
	private double penY;
	private double penWidth = 1;
	private Color penColor = Color.BLACK;
	
	
	public Pen(){
		penWidth = 1;
		penColor = Color.BLACK;
		
	}
	public Line drawLine(double newX, double newY){
		
		Line line = new Line();		
		line.setStroke(penColor);		
		line.setStrokeWidth(penWidth);		
		line.setStartX(penX+13);		
		line.setStartY(penY+25);		
		line.setEndX(newX+13);		
		line.setEndY(newY+25);		
		//default pen width is 1
		
		penX = newX;		
		penY = newY;		
		return line;
		
	}
	
	
	public void updatePenColor(Color color){
		// what sort of colour information is backend going to send?
		penColor = color;
	}
	
	public void updatePenWidth(double width){
		//default is 1
		
		penWidth = width;
	}

	public Color returnPenColor(){
		return penColor;
	}
	
	
	@Override
	public void update() {
		
		
		
	}

}
