/*
Leetcode 189. Rotate Array

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: [1,2,3,4,5,6,7] and k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: [-1,-100,3,99] and k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */
import java.util.Arrays;

public class rotateArray {
	
	
	
    public static void twoArrRotation(int[] nums, int k) {
        
        
        int [] rotateArray = new int[nums.length]; 
       
        for(int i = 0; i < nums.length; i++){
            
        // New rotated position of index i is i----> (i+k)%nums.length    
        rotateArray[(i+k)%nums.length] = nums[i];
      
        }
        
        // Copy back the array
        for(int i = 0; i < nums.length; i++){
        nums[i] = rotateArray[i];
           
        }
        
        
        
}
    
    public static void bruteRotation(int[] nums, int k) {
        
        
        int tmp, previous; 
        for(int j = 0; j < k; j++) {
        // First array element should contain last element	
        previous = nums[nums.length -1]	;
        for(int i = 0; i < nums.length; i++){
        
        //Value to be assigned to previous after swapping
        tmp = nums[i];
        
        // nums[i] = nums[i-1]
        nums[i] = previous;
        
        // Update previous value 
        previous = tmp;	
        	
        }
        }
 
        }    
    
    
	public static void main (String [] args) {
		int[]arrayToRotate  = {1,2,3,4,5,6,7} ;
		int rotateBy = 3;
		System.out.println("Before rotation");
		System.out.println(Arrays.toString(arrayToRotate));
		bruteRotation(arrayToRotate, rotateBy);
		System.out.println("After rotation");
		System.out.println(Arrays.toString(arrayToRotate));
		
		
	}	

    
    

}
