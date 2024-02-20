/* Author: Eden Demke
 * Date: 2/20/24
 * 
 * (Count-down stopwatch) Write a program that allows the user to enter 
 * time in seconds in the text field and press the Enter key to count 
 * down the seconds. The remaining seconds are redisplayed every one 
 * second. When the seconds are expired, the program starts to play 
 * music continuously. 
 * 
 * Use this URL for your Media: 
 * https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3
 */

package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountDownStopWatch extends Application {

	protected Label label = new Label("Enter an integer to start the countdown:");
	protected TextField textField = new TextField();
	protected Text countdownText = new Text();
	protected Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler()));
	protected static final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	protected Media media = new Media(MEDIA_URL);
	protected MediaPlayer mediaPlayer = new MediaPlayer(media);
	
	protected EventHandler<ActionEvent> eventHandler(){
		return e -> {
			if(Integer.parseInt(countdownText.getText()) > 0) {
				countdownText.setText((Integer.parseInt(countdownText.getText()) - 1) + "");
			} else {
				countdownText.setText("0");
				timeline.pause();
				mediaPlayer.play();
			}
		};
	}
	
	protected BorderPane borderPane() {
		BorderPane pane = new BorderPane();
		HBox hboxBottom = new HBox(5);
		hboxBottom.getChildren().addAll(label, textField);
		hboxBottom.setAlignment(Pos.CENTER);
		pane.setBottom(hboxBottom);
		timeline.setCycleCount(Timeline.INDEFINITE);
		countdownText.setFont(Font.font("Times New Roman", 80));
		pane.setCenter(countdownText);
		mediaPlayer.setCycleCount(Duration.INDEFINITE);
		pane.setTop(mediaPlayer);
		
		textField.setOnAction(e -> {
			countdownText.setText(textField.getText());
			timeline.play();
		});
		
		return pane;
	}
	
	public void start(Stage primaryStage) {
		Scene scene = new Scene(borderPane(), 400, 150);
		primaryStage.setTitle("Countdown Stopwatch");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
