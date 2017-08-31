package com.hhlzr.easy;

import java.util.ArrayList;
import java.util.List;

public class _412_FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=0;i<n;i++){
        	if((i+1)%3==0 & (i+1)%5==0)
        		ret.add(i,"FizzBuzz");
        	else if((i+1)%3==0)
        		ret.add(i,"Fizz");
        	else if((i+1)%5==0)
        		ret.add(i,"Buzz");
        	else
        		ret.add(i,String.valueOf(i+1));
        }
        return ret;
    }
}
