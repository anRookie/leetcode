package com.hhlzr.qiuzhao;

import java.util.Scanner;
import java.math.*;  
public class didi01 {
	
    public static void main(String[] args) {
    	
    	Scanner cin = new Scanner(System.in);  
        while (cin.hasNext()){  
           // ����n��  
            BigDecimal r = cin.nextBigDecimal();  
            int n = cin.nextInt();  
            BigDecimal rn = new BigDecimal("1.0");   
            rn = r.pow(n).stripTrailingZeros();//ȥ���ַ���������0�Լ�������BigDecimal�ÿ�ѧ������ʽ����ʾ���  
            String tmp = rn.toPlainString();  
            //ȥ��ǰ��0  
            if(tmp.startsWith("0"))  
                tmp=tmp.substring(1);  
     
             System.out.println(tmp);    
        }
    }
    	
////    	Scanner scan = new Scanner(System.in);
////	 	double r = scan.nextDouble();
////		int n= scan.nextInt();
////		System.out.println(power(r,n));
//    }
//
//    static double power(double r, int n) {
//        double ret = 1;
//        while (n-- >= 1) {
//            ret =ret *  r;
//        }
//        return ret;
//    }
}