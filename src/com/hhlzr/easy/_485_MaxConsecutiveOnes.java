package com.hhlzr.easy;

public class _485_MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int findMaxConsecutiveOnes(int[] nums) {
    	int len = nums[0];
        int ret = len;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]>nums[i-1]) len = nums[i];
            else if(nums[i]<nums[i-1]) {
                ret = ret>len?ret:len;
                len = nums[i];
            }
        	else len += nums[i];
        }
        return ret>len?ret:len;
    }
}
