package com.hhlzr.easy;

public class _6_ZigZagConversion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("ABCD",2));
	}

	static public String convert(String s, int numRows) {
        if(s.length()<2 || s.length()<=numRows || numRows==1)
        	return s;
		String res = ""+s.charAt(0);
        int mod = numRows+numRows-2;
        int i=1;
        int row=0;
        int tempmod = mod;
        int index = 0;
        while(i<s.length()){
        	if((index+tempmod)>=s.length()){
        		tempmod = mod - 2*(++row);
        		index = row;
        	}else{
        		if(row==0 || row==numRows-1){
        			tempmod = mod;
        			index += tempmod;
        		}
        		else{
        			index += tempmod;
        			tempmod = mod-tempmod;
        		}
        	}
        	res += s.charAt(index);
        	System.out.println("res"+res+" index"+index+" char"+s.charAt(index));
        	i++;
        }
		return res;
    }
}
