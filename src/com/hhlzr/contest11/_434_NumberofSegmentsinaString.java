package com.hhlzr.contest11;

public class _434_NumberofSegmentsinaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "      ";
		System.out.println(countSegments(s));
	}

	static public int countSegments(String s) {
		int i = 0;
		int num = 0;
		int flag = 0;
		if(s.length()==0)
			return 0;
		if(s.charAt(i) == ' ')
			flag = 0;
		else{
			flag = 1;num++;
		}
		while (i < s.length()) {
			if (flag==1 && s.charAt(i) == ' ')
				flag = 0;
			if (flag==0 && s.charAt(i) != ' '){
				flag = 1;
				num++;
			}
			i++;
		}
		return num;
	}
}
