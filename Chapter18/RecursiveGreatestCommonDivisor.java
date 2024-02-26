/* Author: Eden Demke
 * Date: 2/26/24
 * 
 * The gcd(m, n) can also be defined recursively as follows:
 * -If m%n is 0, gcd(m, n) is n.
 * -Otherwise, gcd(m, n) is gcd(n, m%n).
 * 
 * Write a recursive method to find the GCD. Write a test 
 * program that prompts the user to enter two integers and 
 * displays their GCD.
 */
package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class RecursiveGreatestCommonDivisor extends Application {
	
	public void start(Stage primaryStage) {
		
		BorderPane borderpane = new BorderPane();
		Scene scene = new Scene(borderpane, 300, 300);
		
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		gridPane.add(new Label("Enter First Integer: "), 0, 0);
		gridPane.add(new Label("Enter Second Integer: "), 0, 1);
		TextField tf1 = new TextField();
		gridPane.add(tf1, 1, 0);
		TextField tf2 = new TextField();
		gridPane.add(tf2, 1, 1);
		Button gcdButton = new Button("Find GCD");
		gridPane.add(gcdButton, 1, 2);
		GridPane.setHalignment(gcdButton, HPos.RIGHT);
		
		StackPane pane = new StackPane();
		
		gcdButton.setOnAction(e -> {
			int int1 = Integer.parseInt(tf1.getText());
			int int2 = Integer.parseInt(tf2.getText());
			int gcd = gcd(int1, int2);
			Label gcdLabel = new Label(gcd + "");
			gcdLabel.setFont(Font.font("Times New Roman", 100));
			pane.getChildren().clear();
			pane.getChildren().add(gcdLabel);
		});
		
		borderpane.setBottom(gridPane);
		borderpane.setCenter(pane);
		
		primaryStage.setTitle("Greates Common Divisor");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static int gcd(int m, int n) {
		int gcd = 0;
		
		if (m % n == 0) {
			gcd = n;
		} else {
			gcd = gcd(n, (m%n));
		}
		
		return gcd;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
