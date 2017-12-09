package com.hhlzr.qiuzhao;

public class dajiang2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3,n = 3;
		int tomx = 0,tomy = 0;
		int gatex = 0,gatey = 0;
		int[][] loc = {{0,1,0},{0,0,0},{0,0,0}};
		System.out.println(zuijialujing(loc,tomx,tomy,gatex,gatey));
	}
	
	public static int zuijialujing(int[][] loc,int tomx,int tomy,int gatex,int gatey){
		int ret = 0;
		int[][] fushe = getfs(loc);
		if(tomx==gatex & tomy==gatey)
			return 0;
		fushe[tomx][tomy] = 2;
		if(fushe[gatex][gatey]==1)
			return -1; 
		else
			fushe[gatex][gatey] = 3;
		ret = sousuo(fushe,tomx,tomy,gatex,gatey,0,0);
		return ret;
	}
	
	public static int[][] getfs(int[][] loc){
		int[][] fs = new int[loc.length][loc[0].length];
		
		for(int i=0;i<loc.length;i++)
			for(int j=0;j<loc[0].length;j++){
				if(loc[i][j]>=1){
					fs[i][j] = 1;
					int loci = i,locj = j;
					while(loci-1>=0 & i-loci<fs[i][j] & i-loci>0) fs[--loci][locj] = 1;
					while(locj-1>=0 & j-locj<fs[i][j] & j-locj>0) fs[loci][--locj] = 1;
					while(loci+1<fs.length & loci-i<fs[i][j] & loci-i>0) fs[++loci][locj] = 1;	
					while(locj+1<fs.length & locj-j<fs[i][j] & locj-j>0) fs[loci][++locj] = 1;
				} 
				else
					fs[i][j] = 0;
			}
		return fs; 
	}
	static int minlength = 0;
	public static int sousuo(int[][] fushe,int sx,int sy,int ex,int ey,int templen,int minlen){
		
		if(sx==ex & sy==ey){
			if(minlength==0)
				minlength = templen;
			if(templen<minlength){
				minlength = templen;
			}
		}
		if(sx-1>=0)
			if(fushe[sx-1][sy]!=1){
				fushe[sx-1][sy] = 1;
				sousuo(fushe,sx-1,sy,ex,ey,templen+1,minlen);
			}
			
		if(sy+1<fushe[0].length)
			if(fushe[sx][sy+1]!=1){
				fushe[sx][sy+1] = 1;
				sousuo(fushe,sx,sy+1,ex,ey,templen+1,minlen);
			}
		if(sx+1<fushe.length)
			if(fushe[sx+1][sy]!=1){
				fushe[sx+1][sy] = 1;
				sousuo(fushe,sx+1,sy,ex,ey,templen+1,minlen);
			}
			
		if(sy-1>=0)
			if(fushe[sx][sy-1]!=1){
				fushe[sx][sy-1] = 1;
				sousuo(fushe,sx,sy-1,ex,ey,templen+1,minlen);
			}
		
		return minlength;
	}
}
