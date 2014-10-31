//This entire file is my masterpiece
// David Zhang

package features;
import java.util.ResourceBundle;

import components.CenterPane;
import properties.Position;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class DisplayTurtle {

    private ResourceBundle numResources;
    private Pen myPen;
    private CenterPane myCenterPane;
    public ImageView myImage;
    private double turtleWidth;
    private double turtleHeight;
    public double turtleX;
    public double turtleY;
    private double middleX;
    private double middleY;
    private double currentX;
    private double currentY;
    public double turtleAngle;
    private double currentAngle;  
    private Line myLine;
    private int penType;
    private boolean penDown;
    public boolean isTurtleShowing;
    private boolean animate; 
    private double animationSpeed;
    private double time;


    public DisplayTurtle (CenterPane pane) {
    	numResources = ResourceBundle.getBundle("resources/constants/numbers");   
        myPen = new Pen();
        myCenterPane = pane;
        initializeTurtlePosition();
        intializeTurtleImage();
        initializePenProps();
        animate = false;
        animationSpeed = 50;
        time = 1;
        isTurtleShowing = true;
    }
    
    private void initializeTurtlePosition(){
    	turtleX = 0;
    	turtleY = 0;
    	currentX = turtleX;
    	currentY = turtleY;
    	middleX = Integer.parseInt(numResources.getString("CenterPane_MiddleX"));
    	middleY = Integer.parseInt(numResources.getString("CenterPane_MiddleY"));
    	turtleAngle = 90;
    	currentAngle = 0;
    }
    
    private void intializeTurtleImage(){
        turtleWidth = Integer.parseInt(numResources.getString("Turtle_Width"));               
        turtleHeight = Integer.parseInt(numResources.getString("Turtle_Height"));
    	Image image = new Image("features/turtle.png");
    	myImage = new ImageView(image);
    	myImage.setFitWidth(turtleWidth);
    	myImage.setFitHeight(turtleHeight);
    	updateImage();
    }

    private void initializePenProps(){
    	penDown = true;
    	penType = 1;
    }

/**
 * Receives position and angle information and calls the appropriate methods to move turtle
 * @param pos: Contains new (x,y) coordinate and new angle information
 */
    public void updatePosition (Position pos) {
        turtleX = pos.getX();
        turtleY = pos.getY();
        turtleAngle = pos.getAngle();
        
        double xDiff = turtleX - currentX;
        double yDiff = turtleY - currentY;
        double distance = Math.sqrt(xDiff * xDiff + yDiff * yDiff);

        time = distance / animationSpeed;

        if (animate == false) {
            myImage.setTranslateX(0);
            myImage.setTranslateY(0);
            updateImage();
            updateLine();
        } else if (animate == true) {
            animateTurtlePosition();
            animateTurtleAngle();
        }

    }
    

    /**
     * Updates the image position as well as angle (no animation)
     */
    private void updateImage () {
        myImage.setLayoutX(middleX + turtleX);
        myImage.setLayoutY(middleY - turtleY);
        myImage.setRotate(90 - Math.toDegrees(turtleAngle));

        currentX = turtleX;
        currentY = turtleY;
    }
    
/**
 * Calls the Translate Transition when animation is turned on and turtle needs to be moved.
 */
    private void animateTurtlePosition () {
        TranslateTransition tt = new TranslateTransition(Duration.seconds(time), myImage);
        tt.setToX(myImage.getX() + turtleX);
        tt.setToY(myImage.getY() - turtleY);
        updateLine();
        tt.play();
    }

    /**
     * Calls the Rotate Transition which animates the rotation of turtle
     */
    private void animateTurtleAngle () {
        RotateTransition rt = new RotateTransition(Duration.millis(500), myImage);
        rt.setFromAngle(currentAngle);
        rt.setToAngle(90 - Math.toDegrees(turtleAngle));
        currentAngle = (90 - Math.toDegrees(turtleAngle));
        rt.play();
    }
    
    /**
     * draws the line by calling appropriate method in pen class and displays it if needed
     */
    private void updateLine () {
       myLine = myPen.drawLine(turtleX, turtleY, turtleWidth, turtleHeight, penType);
        if (penDown == true) {
            myCenterPane.getChildren().add(myLine);

        }
    }

    /**
     * Updates the type of pen to the right ID
     * @param type: integer that corresponds to a type of line to be created
     */
    public void updatePenType (int type) {
        penType = type;
    }
    
    /**
     * updates the pen color
     * @param color: new color of pen
     */
    public void updatePenColor(Color color){
    	myPen.penColor = color;
    }
    
    /**
     * updates the pen width
     * @param width: new width of pen
     */
	public void updatePenWidth(double width){
		myPen.penWidth = width;
	}


    /**
     * updates the turtle image to show or hide
     * @param show: boolean that states whether or not turtle should be showing
     */
    public void updateTurtleShow (boolean show) {
        isTurtleShowing = show;
        if (show == false) {
            myCenterPane.getChildren().remove(myImage);
        }
    }
    
    /**
     * updates the pen to draw or not draw 
     * @param isPenDown: boolean that states whether or not pen should be drawing
     */

    public void updatePenShow (boolean isPenDown) {
        penDown = isPenDown;
    }
    
    /**
     * updates whether or not the turtle's movements should be animated
     * @param animateBool: boolean that states whether or not animation should be turned on
     */
    public void updateAnimate (boolean animateBool) {
        animate = animateBool;
    }
    /**
     * updates the speed so animations can be accurate
     * @param speed: speed passed from the slider
     */
    public void updateSpeed (double speed) {
        animationSpeed = speed;
    }

    
    public void updateImageView (ImageView imageView) {
        myImage.setImage(imageView.getImage());

    }

}
