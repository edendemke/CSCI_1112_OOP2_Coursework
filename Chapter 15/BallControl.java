
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BallControl extends Application {
	private Button btUp = new Button("Up");
	private Button btDown = new Button("Down");
	private Button btLeft = new Button("Left");
	private Button btRight = new Button("Right");
	
	@Override
	public void start(Stage primaryStage) {
		BallPane ballPane = new BallPane();
		
		HBox hbox = new HBox(5);
		hbox.getChildren().addAll(btUp, btDown, btLeft, btRight);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setBottom(hbox);
		hbox.setAlignment(Pos.CENTER);
		
		btUp.setOnAction(e -> ballPane.moveUp());
		btDown.setOnAction(e -> ballPane.moveDown());
		btLeft.setOnAction(e -> ballPane.moveLeft());
		btRight.setOnAction(e -> ballPane.moveRight());
		
		Scene scene = new Scene(pane, 200, 200);
		primaryStage.setTitle("Moving Ball");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
