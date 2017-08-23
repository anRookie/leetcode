package com.hhlzr.easy;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_1_TwoSum ts = new _1_TwoSum();
		int[] nums = { 0, 0, 4 };
		int target = 0;
		for (int k : ts.twoSum(nums, target))
			System.out.println(k);
	}

//	My solution
	public int[] twoSum(int[] nums, int target) {
		int[] adds = { 0, 0 };
		int add2;
		for (int i = 0; i < nums.length; i++) {
			adds[0] = i;
			System.out.println("adds[0]" + adds[0]);
			add2 = target - nums[i];
			for (int j = 0; j < nums.length; j++)
				if (j != i && nums[j] == add2) {
					adds[1] = j;
					System.out.println("adds[1]" + adds[1]);
					for (int k : adds)
						System.out.println(k);
					return adds;
				}
		}
		return adds;
	}
	
//	#3 solution
//	Time complexity : O(n). 
//	Space complexity : O(n).
//	public int[] twoSum(int[] nums, int target) {
//	    Map<Integer, Integer> map = new HashMap<>();
//	    for (int i = 0; i < nums.length; i++) {
//	        int complement = target - nums[i];
//	        if (map.containsKey(complement)) {
//	            return new int[] { map.get(complement), i };
//	        }
//	        map.put(nums[i], i);
//	    }
//	    throw new IllegalArgumentException("No two sum solution");
//	}
}
