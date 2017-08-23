package com.hhlzr.easy;

public class _476_NumberComplement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 1;
		System.out.println(solution1(t));
	}
	public int findComplement(int num) {
		int ret = 0;
		int i = 0;
		while(num>0){
			if(num%2==0)
				ret += Math.pow(2, i);
			i++;
			num = num/2;
		}
		return ret;
    }
	
	public static int solution1(int num) {
		
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        //num 5补码 0000 0101 ~表示取反,~num 1111 1010,计算机存储的是补码，将其转换为原码：
        //符号位不变，逐位取反+1,10000110,即为 -6
        num = ~num;
        return num & mask;
    }
}
