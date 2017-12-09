package com.hhlzr.qiuzhao;

public class dajiang1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int H;
//		int x;
//		int y;
//		int h;
//		int s;
		System.out.println(shuiwei(10,2,1,1,5));
	}
	
	public static int shuiwei(int H,int x,int y,int h,int s){
		int t1 = h/x;
		if(s<t1){
			return s*x;
		}
		else{
			if(x<=y){
				return h;
			}else{
				return h+(x-y)*(s-t1);
			}
		}
	}
}
