/* Author: Eden Demke
 * Date: 2/22/24
 * 
 * (Sum all the integers in a binary data file) 
 * Write a program that contains 2 methods:
 * 
 * 1. Write a method to create a file named Exercise17_03.dat 
 * if it does not exist. Append new data to it if it already 
 * exists. Write 100 random integers into the file using 
 * writeInt(int) in DatatOutputStream. Integers are separated 
 * by a space.
 * 
 * 2. Write a method that reads the integers from the file and 
 * finds the sum of the integers. Assume the file contains an 
 * unspecified number of integers.
 */

package application;

import java.io.*;

public class RealWorldInputOutput {

	public static void main(String[] args) throws IOException {
		createFile();
		readFile();
	}
	
	public static void createFile() throws IOException {
		try (DataOutputStream output = new DataOutputStream(new BufferedOutputStream
				(new FileOutputStream("Exercise17_03.dat", true)))) {
			//write 100 random integers to the file
			//integers are separated by a space
			for (int i = 0; i < 100; i++) {
				output.writeInt((int)(Math.random() * 99));
			}
		}
	}
	
	public static void readFile() throws IOException {
		int total = 0;
		try (DataInputStream input = new DataInputStream(new BufferedInputStream(new
				FileInputStream("Exercise17_03.dat")))) {
			int value;
			while((value = input.readInt()) != -1) {
				System.out.print(value + " ");
				total += value;
			}
		}
		catch(EOFException ex) {
			System.out.println("\nEnd Of File");
		}
		finally {
			System.out.println("Sum of all integers: " + total);
		}
	}

}
