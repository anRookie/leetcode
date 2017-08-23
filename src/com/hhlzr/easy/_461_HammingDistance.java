package com.hhlzr.easy;

public class _461_HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t1 = 7;
		int t2 = 1;
		int hd = hammingDistance(t1,t2);
		System.out.print(hd);

	}
	public static int hammingDistance(int x, int y) {
	        if(x==0 & y==0)
	            return 0;
	        int hd = 0;
	        int a;
            int b;
	        if(x>y){
	            a = x;
	            b = y;
	        }
	        else{
	            a = y;
	            b = x;
	        }
	        
	        while(a>0){
	            if(b==0){
	                if(a%2 == 1)
	                    hd++;
	                a = a/2;
	            }else{      //b!=0 and a!=0
	                if(a%2 != b%2)
	                    hd++;
	                a = a/2;
	                b = b/2;
	            }
	                
	        }            
	        return hd;
	    }
}
