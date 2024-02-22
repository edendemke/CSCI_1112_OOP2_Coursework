/* Author: Eden Demke
 * Date: 2/22/24
 * 
 * (Create a text file) Write a program to create a file named 
 * Exercise17_01.txt if it does not exist. Append new data to 
 * it if it already exists. Write 100 integers created randomly 
 * into the file using text I/O. Integers are separated by a space.
 */

package application;

import java.io.*;

public class InputOutputFundamental {

	public static void main(String[] args) throws IOException {
		
		//create file (if it doesn't exist)
		//if it does exist, append new data to it
		try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream
				(new FileOutputStream("Exercise17_01.txt", true)))) {
			//write 100 random integers to the file
			//integers are separated by a space
			for (int i = 0; i < 100; i++) {
				output.writeInt((int)(Math.random() * 99));
			}
		}
		
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new
				FileInputStream("Exercise17_01.txt")))) {
			int value;
			while((value = input.readInt()) != -1) {
				System.out.print(value + " ");
			}
		}
		catch(EOFException ex) {
			System.out.println("\nEnd Of File");
		}
	}
}
