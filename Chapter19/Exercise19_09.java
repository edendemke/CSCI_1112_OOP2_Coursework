/*
Author: Eden Demke
Date: 2/29/24

Description: Write the following method that sorts an ArrayList.

public static <E extends Comparable<E>> void sort(ArrayList<E> list) 
*/
package assignments;

import java.util.ArrayList;

public class Exercise19_09 {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(14);
    list.add(24);
    list.add(4);
    list.add(42);
    list.add(5);
    Exercise19_09.<Integer>sort(list);
    
    System.out.print(list);
  }
  
  public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
	  E currentMin;
	  int currentMinIndex;
	  
	  for (int i = 0; i < list.size(); i++) {
		  currentMin = list.get(i);
		  currentMinIndex = i;
		  
		  for (int j = i + 1; j < list.size(); j++) {
			 if (currentMin.compareTo(list.get(j)) > 0) {
				currentMin = list.get(j);
				currentMinIndex = j;
			 }
		  }
		  
		  if (currentMinIndex != i ) {
			  list.set(currentMinIndex, list.get(i));
			  list.set(i, currentMin);
		  }
	  }
	  
	  
  }
}
