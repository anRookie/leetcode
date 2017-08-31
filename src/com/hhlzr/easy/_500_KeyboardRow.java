package com.hhlzr.easy;

import java.util.ArrayList;
import java.util.List;

public class _500_KeyboardRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] t = {"Hello","Alaska","Dad","Peace"};
		System.out.println(findWords(t));
	}
	public static String[] findWords(String[] words) {
		List<String> ret = new ArrayList<String>();
		String s1 = "qwertyuiopQWERTYUIOP";
		String s2 = "asdfghjklASDFGHJKL";
		String s3 = "zxcvbnmZXCVBNM";
		String t  = "";
		for(String w:words){
			char c = w.charAt(0);
			if (s1.indexOf(c)!=-1)
				t = s1;
			else if(s2.indexOf(c)!=-1)
				t = s2;
			else if(s3.indexOf(c)!=-1)
				t = s3;
			else {
				continue;
			}
			boolean f = true;
			for(int i=1;i<w.length();i++){
				char ch = w.charAt(i);
				if(t.indexOf(ch)==-1){
					f = false;
					break;
				}
			}
			if(f == true)
				ret.add(w);
		}
		String[] rets = new String[ret.size()]; 
		return  ret.toArray(rets);
    }
}
