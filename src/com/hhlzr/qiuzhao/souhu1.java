package com.hhlzr.qiuzhao;

//import java.util.Scanner;

public class souhu1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		int m = sc.nextInt();
//		int n = sc.nextInt();
//		int[] a=new int[m];
//        for(int i=0;i<m;i++){
//            a[i]=sc.nextInt();
//        }
		int m=2;int n=20;
		int[] a = {1,3};
        int[] t = kolakoski(a,m,n);
        int k =0;
        while(k<n){
			System.out.print(t[k]);
			k++;
		}
	}
	
	public static int[] kolakoski(int[] a,int m,int n){
		int[] ret = new int[n];
		ret[0] = a[0];
		int index1 = 0;
		int index2 = 0;
		int value = a[index1];
		int len = a[0];
		int flag = 0;
		for(int i=0;i<n;i++){
			if(flag<len){
				ret[i] = value;
				flag++;
			}
			else{
				value = a[(++index1)%m];
				index2++;
				if(ret[index2]==0)
					len = value;
				else
					len = ret[index2];
				ret[i] = value;
				flag = 1;
			}
		}
		return ret;
	}
}
