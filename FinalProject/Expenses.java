package application;

public class Expenses extends Budget {
	private String name;
	private double plannedExpense;
	private static double totalExpenses;
	
	public Expenses() {
		addExpense(plannedExpense);
	}
	
	public Expenses(String name, double plannedExpense) {
		this.name = name;
		this.plannedExpense = plannedExpense;
		addExpense(plannedExpense);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPlannedExpense() {
		return plannedExpense;
	}

	public void setPlannedExpense(double plannedExpense) {
		this.plannedExpense = plannedExpense;
		addExpense(plannedExpense);
	}

	public static double getTotalExpenses() {
		return totalExpenses;
	}
	
	//updates totalExpenses and also updates LeftoverIncome
	public void addExpense(double expenseToAdd) {
		Expenses.totalExpenses += expenseToAdd;
		Income.setLeftOverIncome();
	}

	@Override
	public void formattedPrint() {
		System.out.printf("%-7s\t\t%1.2f", this.name, this.plannedExpense);
	}
	
	public String labelPrint() {
		return this.name + "\t||\t\t" + this.plannedExpense + "\t||\t\t" + Expenses.getTotalExpenses();
	}
}
