/*
 * Create a new array with a capacity of 10.
 * int[] array = new int[10];
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * 
*/
package array;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] binaryArray = {1,1,0,1,1,1,0,1,1,1,1};
		int result = findMaxConsecutiveOnes(binaryArray);
		if (result == -1) {
			System.out.println("Exceeded Max length");
		}
		else {
			System.out.println(result);
		}
	}
	public static int findMaxConsecutiveOnes(int[] nums) {
		int maxCountOfOnes= 0;
		int countOne = 0;
		if (nums.length > 10000) {
	        return -1;
	    }
		for (int eachnum=0; eachnum < nums.length; eachnum++){
			if(nums[eachnum] == 1) {
				countOne++;
			}
			else {
				if(countOne > maxCountOfOnes) {
	    			 maxCountOfOnes = countOne;
				}
				countOne = 0;
			}
		}
		if(countOne > maxCountOfOnes) {
			 maxCountOfOnes = countOne;
		}
	     return maxCountOfOnes;
    }

}
