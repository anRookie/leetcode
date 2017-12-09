package com.hhlzr.qiuzhao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

import org.omg.CORBA.IRObject;

import java.math.*;  
public class didi02 {
	
    public static void main(String[] args) {
    	
    	Scanner cin = new Scanner(System.in);  
        while (cin.hasNext()){
        	int m = cin.nextInt();
        	int n = cin.nextInt();
        	int k = cin.nextInt();
        	int i=0;
        	int[][] water = new int[m][n];
        	Set<String> hasland = new HashSet<>();
        	List<Integer> ret = new ArrayList<>();
        	int islandnum = 0;
        	while(i<k){
        		String land = "";
        		int row = cin.nextInt();
        		int col = cin.nextInt();
        		if(row>0 && row<m && col>0&&col<n){
        			if(!hasland.contains(row+""+col))
        				islandnum++;
        			if((row-1)>0 && (row-1)<m && col>0&&col<n)
        				hasland.add((row-1)+""+col);
        			if((row+1)>0 && (row+1)<m && col>0&&col<n)
        				hasland.add((row+1)+""+col);
        			if(row>0 && row<m && (col-1)>0&&(col-1)<n)
        				hasland.add(row+""+(col-1));
        			if(row>0 && row<m && (col+1)>0&&(col+1)<n)
        				hasland.add(row+""+(col-1));
        		}
        		ret.add(islandnum);
        		i++;
        	}
        	for(int reti : ret)
        		System.out.println(reti);
                
        }
    }
    	
}