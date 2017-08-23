package com.hhlzr.easy;

public class _7_ReverseInteger {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1534236469;
		System.out.println(reverse_v2(x));
	}
	
	static public int reverse_v2(int x) {
        int rev=0;
        while(x!=0){
        	if((long)rev*10 != rev*10)
        		return 0;
            rev = rev*10 + x%10;
            x = x/10;
        }
        return rev;
    }
}
