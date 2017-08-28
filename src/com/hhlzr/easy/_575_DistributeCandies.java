package com.hhlzr.easy;

import java.util.HashSet;
import java.util.Set;

public class _575_DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean find(int[] c,int f){
		for (int i = 0; i < c.length; i++) {
			if(c[i]==f){
				return true;
			}
		}
		return false;
	}
	public int distributeCandies(int[] candies) {
        int ret = 0;
        int[] c_flag = new int[candies.length/2];
        int j = 0;
        int f0 = 0;	//set number0 flag,due to 0 is special that 0 is default in array
        for(int i=0;i<candies.length;i++){
        	if(candies[i]==0 & f0==0){
        		f0 = 1;
        		ret++;
        	}
        	else if (find(c_flag, candies[i])==false){
        		c_flag[j++] = candies[i];
        		ret++;
        		if(ret==candies.length/2)
                    break;
        	}
        }
        return ret;
    }
	
	//solution1
	public class Solution2 {
	    public int distributeCandies(int[] candies) {
	        Set<Integer> kinds = new HashSet<>();
	        for (int candy : candies) kinds.add(candy);
	        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
	    }
	}
}
