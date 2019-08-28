//Leetcode 88. Merge Sorted Array

/* 
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

*/
import java.util.Arrays;


public class mergeSortedArray {
 
	  public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        // Starting index to be filled
	        // Sort larger value first, place them at the tail of array nums2
	        int k = n + m -1;
	        int l = m - 1;
	        int r = n - 1;
	        while(( r >= 0)&&( l >= 0)){
	            
	            // Find largest value
	            if(nums2[r] > nums1[l]){
	                
	                // Insert largest at the tail
	                // Update next number to be sorted index by k--
	                // Here nums2 number is picked, so move to the next array element by r--
	                nums1[k--] = nums2[r--];
	            }
	            else {
	                // Here nums1 number is picked, so move to the next array element by l--
	                nums1[k--] = nums1[l--];
	            }
	                  
	        }
	        
	        // Check if all numbers in nums2 have been visited  
	        while(r >= 0) nums1[k--] = nums2[r--];
	        
	        // Check if all numbers in nums1 have been visited 
	        while(l >= 0) nums1[k--] = nums1[l--];
	        
	    }

	

	public static void main (String [] args) {
		
		
		int [] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int [] nums2 = {2,5,6};
		int n = 3 ;
		
		merge(nums1, m, nums2, n);
		
		
		System.out.println(Arrays.toString(nums1));
		// Output [1, 2, 2, 3, 5, 6]
		
		
	}	

}
