/*
 Leetcode 191
 
Write a function that takes an unsigned integer and return the number of '1' bits 
it has (also known as the Hamming weight).

 

Example 1:

Input: 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
Example 2:

Input: 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
Example 3:

Input: 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits. 
*/
public class hammingWeight {
	   // you need to treat n as an unsigned value
    public static int countOnesBit(int n) {
        // Count number of bits 
        int count = 0;
        // mask = 00000000000000000000000000000001
        int mask = 1;
        
        //Check every bit position if its 0 or 1
        for(int i = 0; i < 32; i++){
        //    n = 00000000000000000000000000001011
        //    &   
        // mask = 00000000000000000000000000000001
        //----------------------------------------   
  //result =      00000000000000000000000000000001     
  // Since result is not zero, that means the at position 1 is 0              
                
           if((n & mask) != 0) count++;
            
        // Check next position, position 2     
           mask = mask<<1; 
        // mask = 00000000000000000000000000000010
            
        }
        
        return count;
    }	
    

	public static void main (String [] args) {
		
		int n = 11;// In bits 00000000000000000000000000001011
		
		// Since arrayToSort is passed by reference, it will be sorted as well
		System.out.println( countOnesBit(n));
		// output 3
		
		
	}	
    
	
	
	

}
