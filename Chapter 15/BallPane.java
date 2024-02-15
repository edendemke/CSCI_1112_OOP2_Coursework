
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BallPane extends Pane {
	private double x = 100;
	private double y = 100;
	private double radius = 20;
	private Circle circle = new Circle(x, y, radius);
	
	public BallPane() {
		circle.setFill(Color.PINK);
		circle.setStroke(Color.BLACK);
		getChildren().add(circle);
	}
	
	public BallPane(double x, double y, double radius) {
		this.radius = radius;
		this.x = x;
		this.y = y;
		circle.setRadius(radius);
		circle.setFill(Color.PINK);
		circle.setStroke(Color.BLACK);
		getChildren().add(circle);
	}
	
	public void setX(double x) {
		this.x = x;
		//maybe add part that updates circle?
		
	}
	
	public void setY(double y) {
		this.y = y;
		//maybe add part that updates circle?
		
	}
	
	public void moveLeft() {
		circle.setCenterX(circle.getCenterX() > radius ? circle.getCenterX() - 2 : radius);
	}
	
	public void moveRight() {
		circle.setCenterX(circle.getCenterX() < 200 - radius ? 
				circle.getCenterX() + 2 : 200 - radius);
	}
	
	public void moveUp() {
		circle.setCenterY(circle.getCenterY() > radius ? circle.getCenterY() - 2 : radius);
	}
	
	public void moveDown() {
		circle.setCenterY(circle.getCenterY() < 200 - radius ? 
				circle.getCenterY() + 2 : 200 - radius);
	}
}
