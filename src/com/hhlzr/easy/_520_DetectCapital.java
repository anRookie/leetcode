package com.hhlzr.easy;

public class _520_DetectCapital {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean detectCapitalUse(String word) {
        boolean ret = true;
        int min = 0;
        int max = 0;
        if(word.length()==1)
        	return true;
        if(word.length()==2){
        	int ch1 = word.charAt(0);
        	int ch2 = word.charAt(1);
        	if(ch1>97 & ch1<122 & ch2>65 & ch2<90)
        		return false;
        	else
        		return true;
        }
        if(word.length()>2){
        	int ch1 = word.charAt(0);
        	int ch2 = word.charAt(1);
        	if(ch1>65 & ch1<90 & ch2>65 & ch2<90){
        		min = 65;max = 90;
        	}else if (ch1>97 & ch1<122 & ch2>97 & ch2<122) {
        		min = 97;max = 122;
			}else if (ch1>65 & ch1<90 & ch2>97 & ch2<122) {
				min = 97;max = 122;
			}else{
				return false;
			}
        	int i = 2;
        	while (i<word.length()) {
				if(word.charAt(i)<min | word.charAt(i)>max)
					return false;
			}
        }
        return ret;
    }
}
