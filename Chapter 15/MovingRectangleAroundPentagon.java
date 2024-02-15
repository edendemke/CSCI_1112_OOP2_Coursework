/* Author: Eden Demke
 * Date: 2/15/2024
 * 
 * Animation: rectangle on a pentagon
 * You will write a program that animates a rectangle moving along 
 * the outline of a pentagon. Enable the user to resume/pause the 
 * animation with a click on the mouse. The rectangle's opacity 
 * should change as it moves around the pentagon.
 */

package application;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MovingRectangleAroundPentagon extends Application {

	@Override
	public void start(Stage primaryStage) {
		Pane pane = new Pane();
		
		Rectangle rectangle = new Rectangle(0, 0, 100, 50);
		rectangle.setFill(Color.RED);
		
		Polygon pentagon = new Polygon();
		double radius = 100.0;
		pentagon.setStroke(Color.BLACK);
		pentagon.setFill(Color.WHITE);
		
		pane.getChildren().addAll(pentagon, rectangle);
		Scene scene = new Scene(pane, 300, 300);
		
		double centerX = pane.getWidth() / 2;
		double centerY = pane.getHeight() / 2;
		ObservableList<Double> pentagonPoints = pentagon.getPoints();
		
		//create pentagon x and y coordinates
		for (int i = 0; i < 5; i++) {
			pentagonPoints.add(centerX + radius * Math.cos((2 * i * Math.PI) / 5));
			pentagonPoints.add(centerY - radius * Math.sin((2 * i * Math.PI) / 5));
		}
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.millis(10000));
		pt.setPath(pentagon);
		pt.setNode(rectangle);
		pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.play();
		
		FadeTransition ft = new FadeTransition(Duration.millis(5000), rectangle);
		ft.setFromValue(1.0);
		ft.setToValue(0.1);
		ft.setCycleCount(Timeline.INDEFINITE);
		ft.setAutoReverse(true);
		ft.play();
		
		//when mouse is pressed on pane, fading and movement will pause
		pane.setOnMousePressed(e -> {
			ft.pause();
			pt.pause();
		});
		//when mouse is released, fading and movement will resume
		pane.setOnMouseReleased(e -> {
			ft.play();
			pt.play();
		});
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rectangle Moving Around Pentagon");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
