package com.hhlzr.easy;

public class _566_ReshapetheMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums.length == 0)
			return nums;
		int r0 = nums.length;
		int c0 = nums[0].length;
		if (r0*c0 != r*c)
			return nums;
		int[][] ret = new int[r][c];
		for(int i=0;i<r*c;i++){
			ret[i/c][i%c] = nums[i/c0][i%c0];
		}
		return ret;
    }
}
