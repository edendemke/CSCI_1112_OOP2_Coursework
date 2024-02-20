/* Author: Eden Demke
 * Date: 2/20/24
 * 
 * 16.1 (Use radio buttons) Write a GUI program.
 * You can use buttons to move the message to the 
 * left and right and use the radio buttons to 
 * change the color for the message displayed.
 */

package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RadioButtons extends Application {

	protected Text text = new Text(150, 60, "Eden is the coolest!");
	
	protected BorderPane borderPane() {
		BorderPane borderPane = new BorderPane();
		
		Pane paneForText = new Pane();
		text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 25));
		paneForText.getChildren().add(text);
		borderPane.setCenter(paneForText);
		
		HBox hboxTop = new HBox(10);
		
		RadioButton pinkButton = new RadioButton("Pink");
		RadioButton blueButton = new RadioButton("Blue");
		RadioButton blackButton = new RadioButton("Black");
		RadioButton greenButton = new RadioButton("Green");
		RadioButton yellowButton = new RadioButton("Yellow");
		
		ToggleGroup tGroup = new ToggleGroup();
		pinkButton.setToggleGroup(tGroup);
		blueButton.setToggleGroup(tGroup);
		blackButton.setToggleGroup(tGroup);
		greenButton.setToggleGroup(tGroup);
		yellowButton.setToggleGroup(tGroup);
		hboxTop.getChildren().addAll(pinkButton, blueButton, blackButton,
				greenButton, yellowButton);
		hboxTop.setAlignment(Pos.CENTER);
		borderPane.setTop(hboxTop);
		
		pinkButton.setOnAction(e -> text.setFill(Color.PINK));
		blueButton.setOnAction(e -> text.setFill(Color.BLUE));
		blackButton.setOnAction(e -> text.setFill(Color.BLACK));
		greenButton.setOnAction(e -> text.setFill(Color.GREEN));
		yellowButton.setOnAction(e -> text.setFill(Color.YELLOW));
		
		HBox hboxBottom = new HBox(10);
		
		Button leftButton = new Button("<==");
		Button rightButton = new Button("==>");
		hboxBottom.getChildren().addAll(leftButton, rightButton);
		hboxBottom.setAlignment(Pos.CENTER);
		borderPane.setBottom(hboxBottom);
		
		leftButton.setOnAction(e -> text.setX(text.getX() < 6 ? 0 : text.getX() - 10));
		rightButton.setOnAction(e -> text.setX(text.getX() > 289 ? 295 : text.getX() + 10));
		
		return borderPane;
	}
	
	public void start(Stage primaryStage) {
		Scene scene = new Scene(borderPane(), 500, 150);
		primaryStage.setTitle("Radio Buttons");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
