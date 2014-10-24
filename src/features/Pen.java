package features;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;



public class Pen extends GraphicObject{
	
	private double penX;
	private double penY;
	private double penWidth;
	private Color penColor;
	
	
	public Pen(){
		penWidth = 1;
		penColor = Color.BLACK;
		penX = 275;
		penY = 200;
		
	}
	public Line drawLine(double x, double y){
		
		System.out.println("drawn");
		
		Line line = new Line();		
		line.setStroke(penColor);		
		//line.setStrokeWidth(penWidth);		
		line.setStartX(penX+13);		
		line.setStartY(penY+25);		
		line.setEndX(275+x+13);		
		line.setEndY(200-y+25);		
		//default pen width is 1
		
		penX = 275+x;		
		penY = 200-y;		
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
