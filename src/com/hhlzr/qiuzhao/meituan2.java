package com.hhlzr.qiuzhao;

public class meituan2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public boolean examorder(int num,int[] s){
		boolean ret = false;
		int sum = 0;
		int max = 0;
		for (int i=0;i<s.length;i++){
			sum += s[i];
			if(s[i]>max)
				max = s[i];
		}
		if(max<=sum)
			ret = true;
		else
			ret = false;
		return ret;
	}
}
