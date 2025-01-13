package array;

import java.util.Arrays;

public class SquaresOfSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-1,0,3,10};
//		int[] nums = {-7,-3,2,3,11};
		int[] result = sortedSquares(nums);
		for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
	}
	public static int[] sortedSquares(int[] A) {
		/*if (A.length > 10000 || A.length < 1) {
	        return -1;
	    }*/
		for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

}
