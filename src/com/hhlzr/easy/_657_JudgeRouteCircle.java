package com.hhlzr.easy;

public class _657_JudgeRouteCircle {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t1 = "URDDUL";
		System.out.println(judgeCircle(t1));
	}
	
	public static boolean judgeCircle(String moves) {
		if(moves.length()==0)
			return true;
		int x = 0;
		int y = 0;
		for(int i = 0;i<moves.length();i++){
			
			switch (moves.charAt(i)) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			default:
				return false;
			}
		} 
		if (x==0 & y==0)
			return true;
		else
			return false;
        
    }
}
