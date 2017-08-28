package com.hhlzr.easy;

public class _344_ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "abcd efg";
		System.out.println(reverseString(t));
	}
    public static String reverseString(String s) {
        char[] ca = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = ca[i];
            ca[i] = ca[j];
            ca[j] = temp;
            i++;
            j--;
        }
        return new String(ca);	//new String()���������÷�!֮ǰһֱ����ca�ַ���ת����ʹ����һ���µ��ַ����������ƴ�ӣ�����TLE����
    }
}
