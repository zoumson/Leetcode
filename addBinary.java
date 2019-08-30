/*
 Leetcode 67. Add Binary
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */


public class addBinary {
	   public static String add(String a, String b) {
	        
		     StringBuilder s = new StringBuilder();
		    // string a index 
		    int m = a.length() -1;
		        
		    // string b index    
		    int n = b.length() -1;
		    
		    // Initialization
		    int carry = 0, x, y;
		    while((n >= 0)||(m >= 0)){
		    
		    // Convert character to numeric 
		    if(m >= 0) x = Character.getNumericValue(a.charAt(m--));
		    else x = 0;
		    if(n >= 0) y = Character.getNumericValue(b.charAt(n--));
		    else y = 0;	
		    
		    // Summation
		    int sum = x + y + carry;
		    
		    // Construct the string to be returned 
		    s.append(sum%2);
		    carry = sum/2;
		    	
		    }
		    
		    // If there is carry append it
		    if(carry == 1) {s.append(1);} 
		    
		    // The adding operation is done from left to right, no need to reverse
		    // Also the return object is string not StringBuilder
		    return s.reverse().toString();
		        
		        
		        
		        
		    }	
	   
		public static void main (String [] args) {
			
			
			String a = "1010", b = "1011";
			System.out.println(add(a, b));
			// "10101"
			
			
		}	

	
	
	

}
