/* Author: Eden Demke
 * Date: 2/9/24
 * 
 * Modify the ClockPane class with three new Boolean properties—
 * hourHandVisible, minuteHandVisible, and secondHandVisible—
 * and their associated accessor and mutator methods. You can
 * use the set methods to make a hand visible or invisible.
 * 
 * Write a test program that displays only the hour and minute
 * hands. The hour and minute values are randomly generated.
 * The hour is between 0 and 11, and the minute is either 0 or 30.
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayClock extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        
        clock.setHourHandVisible(true);
        clock.setMinuteHandVisible(true);
        clock.setSecondHandVisible(false);
        
        //random hour and minute times
        clock.setHour((int) (Math.random() * 12));
        
        if(((int) (Math.random() * 2)) < 1) {
        	clock.setMinute(0);
        } else {
        	clock.setMinute(30);
        }

        String timeString = clock.getHour() + ":" + clock.getMinute()
                + ":" + clock.getSecond();
        Label lblCurrentTime = new Label(timeString);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(lblCurrentTime);
        BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Display Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
