/* Author: Eden Demke
 * Date: 2/22/24
 * 
 * (Restore objects from a file) The Loan class in Listing 10.2 does not implement Serializable. 
 * Rewrite the Loan class to implement Serializable. Exercise17_07.java creates a file named 
 * Exercise17_07.dat containing Loan objects that were written using the ObjectOutputStream. 
 * Modify Exercise17_07 by adding a void function called outputData that reads the Loan objects 
 * from the file and displays the total loan amount. Suppose you don’t know how many Loan objects 
 * are there in the file, use EOFException to end the loop.
 */

package application;

import java.io.*;
import java.util.ArrayList;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
        		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
        outputData();
    }
    
    public static void outputData() {
    	ArrayList<Loan> loanList = new ArrayList<>();
    	double totalLoanAmount= 0;
    	
    	try (
        		ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
        ) {
            for (int i = 0; true; i++) {
            	loanList.add((Loan)(input.readObject()));
                totalLoanAmount += loanList.get(i).getTotalPayment();
            }
        } 
    	catch(ClassNotFoundException ex) {
    		System.out.println("\nClass not found");
    	}
    	catch (EOFException ex) {
    		System.out.println("End of File");
    	}
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    	finally {
    		System.out.println("Total Loan Amount: $" + totalLoanAmount);
    	}
    }
}
