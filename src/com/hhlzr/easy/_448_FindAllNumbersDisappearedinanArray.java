package com.hhlzr.easy;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedinanArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(8);
	}
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ret = new ArrayList<>();
    	for(int i=1;i<=nums.length;i++){
    		nums[(nums[i-1]-1)%nums.length] += nums.length;
    	}
    	for(int i=1;i<=nums.length;i++){
    		if(nums[i-1]<=nums.length)
    			ret.add(i);
    	}
    	return ret;
    }
}
