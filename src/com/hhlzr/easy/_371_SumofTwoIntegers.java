package com.hhlzr.easy;

public class _371_SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(2147483647,-2147483647));
		
	}
	
//	思路: 这里用到了一个半加法的思想, 即两位单独的位相加其结果可以用异或得到, 进位可以用与得到. 
//       然后对于两个数字来说同样可以延伸这个思想. 
//	举个例子: 11+5, 其二进制形式为11: 1011, 5: 0101
//	1. 那么两个位置都为1的地方就需要进位, 所以进位值就为0001. 原位置两个数相加的结果为那个位置值的异或即1110, 
//     即两个位置值如果不一样就为1, 一样的话要么两个位置原来值都为0结果也为0, 要么进位, 那么结果依然是0. 
//	2. 接下来就要把进位位和下一位相加, 所以进位值左移一位,即0001变为0010, 重复上面操作可得新的进位值为0010, 
//	         原位置异或(即相加)结果为1100.
//	3. 继续重复上面操作直到进位为0, 可得到最终结果10000, 即16
    public static int getSum(int a, int b) {
    	if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
