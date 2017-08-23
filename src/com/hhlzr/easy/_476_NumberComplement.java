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
        //num 5���� 0000 0101 ~��ʾȡ��,~num 1111 1010,������洢���ǲ��룬����ת��Ϊԭ�룺
        //����λ���䣬��λȡ��+1,10000110,��Ϊ -6
        num = ~num;
        return num & mask;
    }
}
