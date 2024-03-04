/* Author: Eden Demke
 * Date: 3/4/24
 * 
 * Use a GUI and at least 1 other object in this project.
 * 
 * This is a program that the user can use to help them
 * keep track of their budget. They are not allowed to 
 * go over budget. And they should keep budgeting until
 * all of their income has been planned for. This is 
 * known as zero balance budgeting.
 */

package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;

public class BudgetWithGui extends Application {
	VBox balancePane = new VBox();
	ScrollPane scrollPane = new ScrollPane();
	Button updateButtonIncome = new Button("Update Income");
	Button updateButtonExpense = new Button("Update Expenses");
	Label nameOfExpenseLabel = new Label("Name of Expense: ");
	Label expenseAmountLabel = new Label("Expense Amount: ");
	Label nameOfIncomeLabel = new Label("Name of Income: ");
	Label incomeAmountLabel = new Label("Income Amount: ");
	TextField expenseNameTF = new TextField();
	TextField expenseAmountTF = new TextField();
	TextField incomeNameTF = new TextField();
	TextField incomeAmountTF = new TextField();
	GridPane gridPaneIncome = new GridPane();
	GridPane gridPaneExpense = new GridPane();
	GridPane stackedGridPane = new GridPane();
	HBox instructionHbox = new HBox();
	static Label instructions = new Label("Instructions Go Here!!");
	ToggleGroup group = new ToggleGroup();
	VBox radioBtnVbox = new VBox(10);
	RadioButton expenseRadioBtn = new RadioButton("Enter Expense");
	RadioButton incomeRadioBtn = new RadioButton("Enter Income");
	BorderPane borderPane = new BorderPane();
	protected Label newInstructions = new Label("");
	protected Label balanceLabel1 = new Label("Income\t||\tPlanned Amount\t||\tTotal" +
			"\n---------------------------------------------------\n"	);
	protected Label balanceLabel2 = new Label("\nExpense\t||\tPlanned Budget\t||\tTotal" +
			"\n---------------------------------------------------\n"	);
	protected ArrayList<Income> incomeList = new ArrayList<>();
	protected ArrayList<Expenses> expenseList = new ArrayList<>();
	
	public void start(Stage primaryStage) {
		balancePane.setPrefWidth(300);
		balancePane.getChildren().addAll(balanceLabel1, balanceLabel2);
		
		instructions.setText("Enter expense or income to get started. Add name and amount, then press the update button.");
		instructions.setTextFill(Color.BLUE);
		instructions.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));

		gridPaneIncome.add(nameOfIncomeLabel, 0, 0);
		gridPaneIncome.add(incomeNameTF, 1, 0);
		gridPaneIncome.add(incomeAmountLabel, 0, 1);
		gridPaneIncome.add(incomeAmountTF, 1, 1);
		gridPaneIncome.add(updateButtonIncome, 1, 2);

		gridPaneExpense.add(nameOfExpenseLabel, 0, 3);
		gridPaneExpense.add(expenseNameTF, 1, 3);
		gridPaneExpense.add(expenseAmountLabel, 0, 4);
		gridPaneExpense.add(expenseAmountTF, 1, 4);
		gridPaneExpense.add(updateButtonExpense, 1, 5);

		stackedGridPane.setPrefWidth(300);
		stackedGridPane.getChildren().add(gridPaneIncome);
		
		expenseRadioBtn.setToggleGroup(group);
		incomeRadioBtn.setToggleGroup(group);
		incomeRadioBtn.setSelected(true);
		radioBtnVbox.getChildren().addAll(expenseRadioBtn, incomeRadioBtn);
		radioBtnVbox.setPrefWidth(150);
		
		expenseRadioBtn.setOnAction(e -> {
			stackedGridPane.getChildren().clear();
			stackedGridPane.getChildren().add(gridPaneExpense);
		});
		
		incomeRadioBtn.setOnAction(e -> {
			stackedGridPane.getChildren().clear();
			stackedGridPane.getChildren().add(gridPaneIncome);
		});
		
		updateButtonIncome.setOnAction(e -> {
			incomeList.add(new Income(Double.parseDouble(incomeAmountTF.getText()), incomeNameTF.getText()));
			
			//add a call to make balanceLabel update?
			updateBalance(balancePane);
			
			incomeNameTF.clear();
			incomeAmountTF.clear();
		});
		
		updateButtonExpense.setOnAction(e -> {
			if (Income.getTotalIncome() - (Expenses.getTotalExpenses() + Double.parseDouble(expenseAmountTF.getText())) < 0) {
				newInstructions.setText("ERROR: you only have $" + Income.getLeftOverIncome() +
						" left in your budget. Try again.");
				newInstructions.setTextFill(Color.RED);
				
				//add error in instruction label
				BudgetWithGui.setInstructions(newInstructions);
				instructions.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
				instructionHbox.getChildren().clear();
				instructionHbox.getChildren().add(instructions);
			} else {
				expenseList.add(new Expenses(expenseNameTF.getText(), Double.parseDouble(expenseAmountTF.getText())));
			}
			
			if(Income.getLeftOverIncome() < 0.0100000000) {
				newInstructions.setText("You have successfully budgeted all of your money!");
				newInstructions.setTextFill(Color.GREEN);
				
				//add to instruction label
				BudgetWithGui.setInstructions(newInstructions);
				instructions.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
				instructionHbox.getChildren().clear();
				instructionHbox.getChildren().add(instructions);
			} else {
				newInstructions.setText("You have $" + Income.getLeftOverIncome() + " left to budget.");
				newInstructions.setTextFill(Color.GREEN);
				
				//add to instruction label
				BudgetWithGui.setInstructions(newInstructions);
				instructions.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 15));
				instructionHbox.getChildren().clear();
				instructionHbox.getChildren().add(instructions);
			}
			
			updateBalance(balancePane);
			
			expenseNameTF.clear();
			expenseAmountTF.clear();
		});
		
		updateBalance(balancePane);
		scrollPane.setContent(balancePane);
		
		instructionHbox.getChildren().add(instructions);
		instructionHbox.setAlignment(Pos.CENTER);
		instructionHbox.setPrefHeight(150);
		
		borderPane.setRight(scrollPane);
		borderPane.setCenter(stackedGridPane);
		borderPane.setTop(instructionHbox);
		borderPane.setLeft(radioBtnVbox);
		
		Scene scene = new Scene(borderPane, 800, 600);
		primaryStage.setTitle("Zero Balance Budget");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public Label getInstructions() {
		return instructions;
	}

	public static void setInstructions(Label newInstructions) {
		instructions = newInstructions;
	}
	
	public void updateBalance(VBox pane) {
		pane.getChildren().clear();
	
		pane.getChildren().add(balanceLabel1);
		
		for (Income individual: incomeList) {
			Label incomeLabel = new Label(individual.labelPrint());
			pane.getChildren().add(incomeLabel);
		}
		
		pane.getChildren().add(balanceLabel2);
		
		for (Expenses individual: expenseList) {
			Label expenseLabel = new Label(individual.labelPrint());
			pane.getChildren().add(expenseLabel);
		}
	}
}
