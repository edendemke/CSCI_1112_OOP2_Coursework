import java.util.Scanner;

/* Author: Eden Demke
 * Date: 2/26/24
 * 
 * Write a recursive method that displays a string reversely on 
 * the console using the following header: 
 * 
 * public static void reverseDisplay(String value)
 */

public class ReverseString {
		
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Type a string: ");
		String userString = input.nextLine();
		
		System.out.println("The reverse of your string is:");
		reverseDisplay(userString);
	}
	
	public static void reverseDisplay(String value) {
		int first = 0;
		int last = value.length() - 1;
		char[] charArray = value.toCharArray();
		
		reverseDisplay(charArray, first, last);
	}
	
	public static void reverseDisplay(char[] charArray, int first, int last) {
		char temp = '1';
		
		//swap first char with value.length (or value.length - 1??)
		temp = charArray[first];
		charArray[first] = charArray[last];
		charArray[last] = temp;
		
		if(last <= charArray.length / 2) {
			//print charArray as reverse string
			for (char e: charArray) {
				System.out.print(e);
			}
		} else {
			reverseDisplay(charArray, first + 1, last - 1);
		}
		//move "first" up one index, move "last" down one index
	}
}
