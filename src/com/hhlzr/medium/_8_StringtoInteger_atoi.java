package com.hhlzr.medium;


public class _8_StringtoInteger_atoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myAtoi("2147483648"));
	}
    public static int myAtoi(String str) {
    	int ret = 0;
        boolean oper = true;
        boolean begin = false;
        for(int i=0;i<str.length();i++){
        	char num = str.charAt(i);
        	if(!begin){
        		if(num == '-'){
        			begin = true;
        			oper = false;
        		}else if(num == '+'){
        			begin = true;
        		}else if(48<=num & num<=57){
        			begin = true;
        			ret = num-48;
        		}else if(num == ' '){
        			;
        		}else {
					break;
				}
        	}else {
        		if(48<=num & num<=57){
        			if (ret >  2147483647 / 10 || (ret == 2147483647 / 10 && num - '0' > 7)) {
        	            if (oper) return 2147483647;
        	            else return -2147483648;
        	        }
            		ret = ret*10 + num - 48;
            	}else {
            		break;
				}
			}
        }
        if(oper){
        		return ret;
        }
        else{
            	return -ret;
        }
    }
}
