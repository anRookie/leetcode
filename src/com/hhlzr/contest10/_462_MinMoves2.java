package com.hhlzr.contest10;

import java.util.Arrays;

public class _462_MinMoves2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Solution {
	    public int minMoves2(int[] nums) {
	        int moves = 0;
	        Arrays.sort(nums); 
	        int std = nums.length/2;
	        for(int i=0;i<nums.length;i++){	
	        	if (i<std)
	        		moves +=  nums[std]- nums[i];
	        	if (i>std)
	        		moves +=  nums[i]- nums[std];
	        }
	        return moves;
	    }
	}
}
