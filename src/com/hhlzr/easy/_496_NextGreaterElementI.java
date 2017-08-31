package com.hhlzr.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496_NextGreaterElementI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] ret = new int[nums1.length];
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0;i<nums2.length;i++)
			nums.add(nums2[i]);
		int index = 0;
        boolean flag = false;
		for(int i=0;i<nums1.length;i++){
            flag = false;
			index = nums.indexOf(nums1[i]);
			for(int j=index+1;j<nums2.length;j++){
				if(nums2[j]>nums1[i]){
					ret[i] = nums2[j];
					flag = true;
                    break;
				}
			}
			if(flag==false)
				ret[i] = -1;
		}
    	return ret;
    }
    
//    Java 10 lines linear time complexity O(n) with explanation
    public int[] solution2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }   
        for (int i = 0; i < findNums.length; i++)
            findNums[i] = map.getOrDefault(findNums[i], -1);
        return findNums;
    }
}
