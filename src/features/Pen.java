package features;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;



public class Pen {
	
	private double penX;
	private double penY;
	public double penWidth;
	private double turtleWidth;
	private double turtleHeight;
	public double middleX;
	public double middleY;
	public Color penColor;
	//private Line line;
	
	
	public Pen(){
		penWidth = 1;
		penColor = Color.BLACK;
		middleX = 275;
		middleY = 200;
		penX = middleX;
		penY = middleY;	
		//line = new Line();
		
	}
	
	/**
	 * 
	 * @param x: new x coordinate
	 * @param y: new y coordinate
	 * @param tWidth: turtle width to take offset into consideration
	 * @param tHeight: turtle height to take offset into consideration
	 * @param type: integer that corresponds to the correct line style to be drawn
	 * @return a line that is to be added to center pane
	 */
	public Line drawLine(double x, double y, double tWidth, double tHeight, int type){
		
		Line line = new Line();
		if(type == 1){
			line.getStrokeDashArray().addAll();
		}else if(type == 2){
			line.getStrokeDashArray().addAll(6d);			
		}else if(type == 3){
				line.getStrokeDashArray().addAll(5d, 5d, 1d, 4d);
			}else if(type == 4){
			line.getStrokeDashArray().addAll(3d);
		}
			
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

	
}
