package com.hhlzr.contest11;

public class _13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMaxRepetitions("niconiconi",
				99981,
				"nico",
				81));
	}

	static public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if(s2.length()*n2>s1.length()*n1)
			return 0;
		if(s1.equals(s2))
			return n1/n2;
		String si1="";
		String si2="";
		for(int i=0;i<n1;i++)
			si1 += s1;
		for(int i=0;i<n2;i++)
			si2 += s2;
		int i = 0;
		int num = 0;
		int j = 0;
		System.out.println("si1.length():"+si1.length());
		while(i<si1.length()){
			System.out.println("si2.length():"+si2.length());
			while(j<si2.length()){
				if(si2.charAt(j)!=si1.charAt(i)){
					i++;
				}
				if(si2.charAt(j)==si1.charAt(i)){
					j++;i++;
				}
				System.out.println("j:"+j);
				System.out.println("i:"+i);
				if(i==si1.length())
					return num;
			}
			num++;
			System.out.println("s2:"+s2);
			System.out.println("qian si2:"+si2);
			si2+=s2;
			System.out.println("hou si2:"+si2);
		}
		return num;
	}
}
