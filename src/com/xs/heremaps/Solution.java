package com.xs.heremaps;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		int [] a = new int [] {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0};
		System.out.println(Arrays.toString(a)+", Total No Of Stability "+sol.solution(a));
		
		a = new int [] {-2,1,4,7,11,15,21,100};
		System.out.println(Arrays.toString(a)+", Total No Of Stability "+sol.solution(a));
	}
	
	public int solution(int[] A) {
        int lastIndexOfSubArray = 0, lastIndexofMainArray = -1;
        int totalElements = A.length;
        int noOfTimesStable = 0; 
        int [] subArray = null;
        int prevDiff = 0, diff = 0;
        boolean isStableFound = false;
        
        // iterating through main array
        for(int x = 0; x < totalElements; x++){
        	// hardcode the last index of sub-array
        	// so that we start creating sub array of length 3. 
            lastIndexOfSubArray = x + 3; 
            isStableFound = false; // signifies whether stability has found, i.e number difference is same as previous numbers
            subArray = null; 
            prevDiff = 0;
            diff = 0;
            
            do{
				
                // create sub-array to check stability
                if(lastIndexOfSubArray <= totalElements){
                    
                    // create a subarray from main array   
                    subArray = Arrays.copyOfRange(A,x,lastIndexOfSubArray);
                    
                    // iterate through subarray of checking stability    
                    for(int m = 0; m < subArray.length; m++){
                        
                        // if stablity already found in previously 
                        // computed sub array of length 3 than after increasing the 
                        // sub array length to 4, 5, 6 and hence forth, just jump to the
                        // second last element position.
                        if(isStableFound == true && subArray.length > 3 && m == 0){
                            m = subArray.length - 2;
                        }
                        
                        if(m == 0){
                            prevDiff = subArray[m + 1] - subArray[m];  							
                        }else if(m < (subArray.length - 1)){
							diff = subArray[m + 1] - subArray[m];
							
							// check for stability with previous differences	
							if(diff == prevDiff){
	                            noOfTimesStable++;
	                            isStableFound = true;							
	                        }else{
	                            isStableFound = false;                            
	                        }
						}else {
							continue;
						}
												
                    } // end of for
                    
                    // if stablity found, then increase the range of sub-array
                    if(isStableFound == true){
    					lastIndexOfSubArray++; 
                    }
                }else {
                	isStableFound = false;
                }
				
            }while(isStableFound == true);
            
        }// end of for
        
        if(noOfTimesStable > 1000000000){
           noOfTimesStable = -1; 
        }
        
        return noOfTimesStable;
    } // end of method

}
