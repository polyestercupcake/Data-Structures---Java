
package model;

public class HashFunction {
	
	public String getHash(String valueToHash) {
//		char[] nums = valueToHash.toCharArray();
//		Integer result = 0;
//		List<Integer> results = new ArrayList<>();
//
//		for (int n : nums) {
//			result = Character.getNumericValue(n);
//			results.add(result);
//		}
//		concatenateDigits(valueToHash);
		return bitwiseOperations(valueToHash.toString());

	}
//	
//	public static String concatenateDigits(String digits) {
//		   StringBuilder sb = new StringBuilder(digits.length());
//		   
//		   for(int n=0; n<=digits.length();n++) {
//			   sb.append(n);
//		   }
//		   return sb.toString();
//		}
	
	public static String bitwiseOperations(String s) {
		//getting bytes from the concatenated string
		byte[] toByte = s.getBytes();
		Integer result = 24;
		//converting back to int..doing lots of operations...then to hex string
	    for (int i = 0; i < toByte.length; i++) {
	      result = (result << 2) 
	    		  + (result & 3) 
	    		  + (result >> 1) 
	    		  + (result | 2)
	    		  - (result << 5)
	    		  + (int) toByte[i]
	    		+ (int) toByte[i];
	    }
	    for (int i = 0; i < toByte.length; i++) {
		      result = (result << 232) 
		    		  + (result % 312) 
		    		  + (result >> 8) 
		    		  + (result | 9)
		    		  - (result^2 << 7)
		    		  + (int) toByte[i]
		    		+ (int) toByte[i]
		    		* (int) toByte[i];
		    }
	    for (int n : toByte) {
	    	n = (n << 232) 
	    		+ (n % 312)
	    		+ (n >> 145)
	    		+ (n << 223)
	    		+ (n >> 5124)
	    		+ (n^2 << 2)
	    		+ Byte.MIN_VALUE - Byte.MAX_VALUE;
	    	result = result - (n*(n+1));
	    }
	    for (int n : toByte) {
	    	n = (n << 232) 
	    		+ (n | 312)
	    		+ (n & 14)
	    		+ (n | 223)
	    		+ (n & 124324)
	    		+ (n % 9999)
	    		- Byte.MAX_VALUE;
	    	result = result - (n*(n+7));
	    }
	    for (int n : toByte) {
	    	n = (n | 232217) 
	    		+ (n | 31223)
	    		+ (n & 14823)
	    		- (n << 223)
	    		+ (n >> 12) 
	    		+ (n^3 << 8);
	    	result = result + n;
	    }
	    return Integer.toHexString(result);
	  }
}
/*
 * Study for mid-term
 * 
 * Difference between ADT and Data Structure
 * SelectionSort has n^2 number of swaps
 * BubbleSort has n^2 number of swaps
 * compares for SelectionSort = n^2
 * compares for BubbleSort = n^2
 * 
 * Binary Search Tree does not allow duplicates, but Binary Tree does
 * 
 * Priority queues
 * It depends!
 * 
 * Big-O is about complexity...it'll still be on the order of n no matter what you run it on
 * 
 */
