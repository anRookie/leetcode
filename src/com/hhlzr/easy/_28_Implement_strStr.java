package com.hhlzr.easy;

public class _28_Implement_strStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "aabaaabaaac";
		String needle = "aabaaac";
		System.out.println(strStr(haystack,needle));
	}
	
	public static int[] next(String needle){
		int len = needle.length();
		int[] next = new int[len+1];
		next[0] = 0;
		next[1] = 0;
		int j = 0;
		for(int i=1;i<len;i++){
			while(j>0 && needle.charAt(i)!=needle.charAt(j))
				j = next[j];
			if(needle.charAt(i)==needle.charAt(j))
				j++;
			next[i+1] = j;
		}
		return next;
	}
	public static int strStr(String haystack, String needle) {
		int len = needle.length();
		if(len==0)
            return 0;
		int j = 0;
		int[] next = next(needle);
		for(int i=0;i<haystack.length();i++){
			while(j>0 && haystack.charAt(i)!=needle.charAt(j))
				j = next[j];
			if(haystack.charAt(i)==needle.charAt(j)){
				j++;
			}
			if(j==len){
				return i-j+1;
			}
				
		}
		return -1;
    }
}
