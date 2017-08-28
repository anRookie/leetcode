package com.hhlzr.easy;

public class _338_CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public int[] countBits(int num) {
        int[] ret = new int[num+1];
        for(int i=1;i<num+1;i++)
        	ret[i] = ret[i/2] + i&1;
        return ret;
    }
}
