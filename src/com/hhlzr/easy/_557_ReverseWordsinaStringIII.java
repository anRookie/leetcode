package com.hhlzr.easy;

public class _557_ReverseWordsinaStringIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	my poor solution 322ms
    public String reverseWords(String s) {
    	if(s.length()==0)
    		return s;
    	String[] rets = s.split(" ");
    	String ret = "";
    	for (int i=0;i<rets.length;i++){
    		StringBuffer sb = new StringBuffer(rets[i]);
    		ret += sb.reverse().toString();
            if(i<rets.length-1)
    			ret += " ";
    	}
		return ret;
    }
//    solution1 10ms
    public String reverseWords2(String s) 
    {
        char[] s1 = s.toCharArray();
        int i = 0;
        for(int j = 0; j < s1.length; j++)
        {
            if(s1[j] == ' ')
            {
                reverse(s1, i, j - 1);
                i = j + 1;
            }
        }
        reverse(s1, i, s1.length - 1);
        return new String(s1);
    }

    public void reverse(char[] s, int l, int r)
    {
    	while(l < r)
    	{
    		char temp = s[l];
    		s[l] = s[r];
    		s[r] = temp;
    		l++; r--;
    	}
    }
}
