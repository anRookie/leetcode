package com.hhlzr.qiuzhao;

import java.util.Scanner;

public class aa91501 {

	 public static void main(String[] args) {
		 	Scanner scan = new Scanner(System.in);
		 	String pattern = scan.nextLine();
			String content= scan.nextLine();
	        if (null == pattern || null == content)
	            System.out.println(false);
	        System.out.println(match(pattern, content, 0, 0));
	}
	
	static boolean match(String pattern, String content, int p, int c) {
        if (pattern.length() == p && content.length() == c)
            return true;
        if (pattern.length() > p && '*' == pattern.charAt(p) && pattern.length() > p + 1 && content.length() == c)
            return false;
        if (pattern.length() > p && content.length() > c && ('?' == pattern.charAt(p) || pattern.charAt(p) == content.charAt(c)))
            return match(pattern, content, p + 1, c + 1);
        if (pattern.length() > p && '*' == pattern.charAt(p))
            return match(pattern, content, p + 1, c) || match(pattern, content, p, c + 1);
        return false;
    }

}
