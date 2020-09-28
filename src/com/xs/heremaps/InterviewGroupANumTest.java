package com.xs.heremaps;

import java.util.Arrays;

/*
 * This is an interview question asked in HERE MAPS.
 * the question is, given an array of random numbers, group a number and let the other numbers as it is.
 * 
 * Input an array of random numbers, and a number which has to be grouped
 */
public class InterviewGroupANumTest {

	public static void main(String[] args) {
		int [] randomNumArray = new int[] {5, 2, 8, 4, 3, 2, 10, 4, 5, 2, 4, 66, 2, 3, 9, 67, 2}; // input array
		int num = 2; // number to be grouped
		int totalLength = 0;
		int i = 0;
		int temp = 0;
		try {
			totalLength = randomNumArray.length;
			
			/*
			 * First check if the first number of the array is the desired number to be grouped,
			 * if not, than find the the number and place it in first position
			 */
			if(randomNumArray[i] != num) {
				for(int j = (i+1) ; j < totalLength; j++) {					
					if(randomNumArray[j] == num) {
						temp = randomNumArray[j];
						randomNumArray[j] = randomNumArray[i];
						randomNumArray[i] = temp;
						break;
					}
				}
			}
			
			/*
			 * Search for the number in the sub-array and group it
			 */
			for(int j = (i+1); j < totalLength; j++) {
				
				if(randomNumArray[j] != num) {
					for(int k = (j+1); k < totalLength; k++) {
						
						// swap
						if(randomNumArray[k] == num) {
							temp = randomNumArray[k];
							randomNumArray[k] = randomNumArray[j];
							randomNumArray[j] = temp;
							break;
						}
					}
					
				}
			}
			
			System.out.println(Arrays.toString(randomNumArray));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
