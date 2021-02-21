// John Holliday

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSortEnhance {

	public static void main(String[] args) {
		
		int sizeOfCollection;
		int minValue;
		int maxValue;
		
		Random n = new Random();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Sorting Method Lab");
		System.out.println("Author: John Holliday");
		System.out.println("Using the Bubble Sort");
		
		try {
		
			// asks user for size of collection
			System.out.print("Enter the size of your collection:");
			sizeOfCollection = scanner.nextInt();
			
			// asks user for min value (Won't be included.)
			System.out.print("Enter the minimum value:");
			minValue = scanner.nextInt();
			
			// asks user for max value that may be included. (Inclusive, so it can be included, but doesn't need to be). 
			System.out.print("Enter the maximum inclusive value:");
			maxValue = scanner.nextInt();
			
			// new array based on the size user entered
			int userArray[] = new int[sizeOfCollection];
			
			// generates random numbers from the min and max given from user. 
			for (int i = 0; i < userArray.length; i++) {
				userArray[i] = n.nextInt(maxValue - minValue) + (minValue + 1);
			}
			
			System.out.print("\nThe values are: ");
			
			// loops through array to print out values
			for (int i = 0; i < userArray.length; i++) {
				System.out.print(userArray[i] +  "  ");
			}
			
			System.out.print("\n\nSorted: ");
			
			// new array for first sort. 
			int bubbleSortArray[] = new int[userArray.length];
			
			// user array for short circuit
			int userArrayShortCircuit[] = new int[userArray.length];
			
			// copies users array to array for short circuit
			for (int i = 0; i < userArray.length; i++) {
				userArrayShortCircuit[i] = userArray[i];
			}
			
			// sets the sort array and calls method
			bubbleSortArray = bubbleSort(userArray);
			
			// calls method for short circuit. 
			bubbleSortShortCircuit(userArrayShortCircuit, bubbleSortArray);
			
			scanner.close();
			
		} catch(Exception e) {
			System.out.print("Please enter valid integers.");
			scanner.close();
		}
		

	}
	
	public static int[] bubbleSort(int[] arr) {
		// run time int
		int runTime = 0;
		
		// loops through array
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				// checks if index of j is greater than next int
				if (arr[j] > arr[j + 1]) {
					
					// swaps
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
				// increases runTime after each inner loop runs. 
				runTime++;
			}
		}
		
		// prints out array, sorted. 
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +  "  ");
		}
		
		// prints out run time
		System.out.println("\n\nRun time with all elemets compared: " + runTime);
		
		// return sorted array
		return arr;
		
	}
	
	public static int[] bubbleSortShortCircuit(int[] arr, int[] sortedarr) {
		int runTime = 0;
		
		// loops through array
		loop : for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				// if array already equals sorted array, exits loop
				if (!(Arrays.equals(arr, sortedarr))) {
					if (arr[j] > arr[j + 1]) {
						
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				} else {
					break loop;
			} 
				// increases runTime after each time inner loop is ran. 
				runTime++;
		}
	}

		// prints out runTime
		System.out.println("Run time with short circuting: " + runTime);
		
		// returns sorted array. 
		return arr;
		
	}
	

}










