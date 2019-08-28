
// Leetcode 912. Sort an Array
import java.util.Arrays;
public class quicksort {
	
	   
    // This helper method sort the pivot within the entire array
    public static int part(int[] nums, int start, int end){
        // Choose last element as pivot
        int pivot = nums[end];
        
        // Pivot final index location
        int replace = start;
        
        // All values less than pivot are move to the left
        for(int i = start; i < end; i++){
            
        // Swapping     
            if(nums[i] < pivot){
                int tmp = nums[i];
                nums[i] = nums[replace];
       // Next index for element less than pivot         
                nums[replace++] = tmp;
                
                
            }
            
        }
        
        // Bring the pivot to its right place 
                int tmp = nums[end];
                nums[end] = nums[replace];
                nums[replace] = tmp; 
        
        // return pivot index
        return replace;    
    }
    
    
    // Apply quick sort on both right and left hand side of the pivot
    public static void quick(int[] nums, int start, int end){
        
        if(start < end){
            
            // Pivot index
            int p = part(nums, start, end);
            
            // Sort element before the pivot
            quick(nums, start, p -1);
            
            // Sort element after the pivot
            quick(nums, p + 1, end);
                  
            
        }
        
        
    }
    
    
    
    public static int[] sortArray(int[] nums) {
        // call quick sort function
        quick(nums, 0, nums.length-1);
        
        // Array address is returned 
        return nums;     
        
    }
	

	public static void main (String [] args) {
		
		// Sample array to be sorted 
		int []arrayToSort = {-34, 9, 8,1,-22,0};
		
		int []sortedArray = sortArray(arrayToSort);
		
		// Since arrayToSort is passed by reference, it will be sorted as well
		System.out.println(Arrays.toString(sortedArray));
		
		
		
	}	

}
