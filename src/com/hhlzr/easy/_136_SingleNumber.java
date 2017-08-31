package com.hhlzr.easy;

public class _136_SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int singleNumber(int[] nums) {
    	int j = nums.length-1;
        for(int i=0;i<nums.length; i++){
			if(i!=j && nums[i]==nums[j]){
				i = -1;
				j--;
			}
		}
        return nums[j];
    }
    
    //Easy Java solution (tell you why using bitwise XOR)
    public int singleNumber2(int[] nums) {
        int ans =0;
        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];
        return ans;
    }
}
