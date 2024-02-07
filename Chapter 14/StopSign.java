/* Author: Eden Demke
Date: 2/7/2024

This is a javafx program to create a stop sign.
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;

public class StopSign extends Application {

    public void start(Stage primaryStage){

        //create the StackPane
        StackPane pane = new StackPane();

        //create the white under octagon first
        Polygon octagon = new Polygon();
        octagon.setFill(Color.WHITE);
        octagon.setStroke(Color.BLACK);
        ObservableList<Double> pointsList = octagon.getPoints();

       double centerX = 400 / 2, centerY = 400 / 2;
       double radius = Math.min(400, 400) * 0.42; //how does this give you the radius?

        /* create 8 points for the octagon, and add them
        to the list of points. (I'm not sure how this is working,
        but this is what the example showed.) */
        for (int i = 0; i < 8; i++) {
            pointsList.add(centerX + radius * Math.cos(2 * i * Math.PI / 8 - Math.PI / 8));
            pointsList.add(centerY - radius * Math.sin(2 * i * Math.PI / 8 - Math.PI / 8));
        }

        //add the octagon with all of its points to the pane I guess
        pane.getChildren().add(octagon);

        //create the main red octagon
        Polygon octagonRed = new Polygon();
        octagonRed.setFill(Color.RED);
        octagonRed.setStroke(Color.WHITE);
        ObservableList<Double> redPointsList = octagonRed.getPoints();

        radius = Math.min(400, 400) * 0.4;

        /* create 8 points for the octagon, and add them
        to the list of points. (I'm not sure how this is working,
        but this is what the example showed.) */
        for (int i = 0; i < 8; i++) {
            redPointsList.add(centerX + radius * Math.cos(2 * i * Math.PI / 8 - Math.PI / 8));
            redPointsList.add(centerY - radius * Math.sin(2 * i * Math.PI / 8 - Math.PI / 8));
        }

        //add the octagon with all of its points to the pane I guess
        pane.getChildren().add(octagonRed);

        //create the "stop" text to go on top of the sign
        Text stopText = new Text(centerX, centerY, "STOP");
        stopText.setFont(Font.font("Highway Gothic", FontWeight.BOLD, FontPosture.REGULAR, 110));
        stopText.setFill(Color.WHITE);
        pane.getChildren().add(stopText);


        //place the pane on the scene, and the scene on the stage. show stage.
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Stop Sign");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
