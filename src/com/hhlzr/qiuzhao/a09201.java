package com.hhlzr.qiuzhao;

import java.util.ArrayList;   
import java.util.List;
import java.util.function.IntPredicate;   
  
  
public class a09201 {   
  
    private static int INF=Integer.MAX_VALUE;   
         //dist[i][j]=INF<==>i 和 j之间没有边   
    private static int[][] dist;   
         //顶点i 到 j的最短路径长度，初值是i到j的边的权重     
    private static int[][] path;     
    private List< Integer> result=new ArrayList< Integer>();   
       
    public static void main(String[] args) {   
        a09201 graph=new a09201(5);   
        int[][] matrix={   
                {INF,30,INF,10,50},   
                {INF,INF,60,INF,INF},   
                {INF,INF,INF,INF,INF},   
                {INF,INF,INF,INF,30},   
                {50,INF,40,INF,INF},   
        };   
 /*              最下面的图
           int[][] matrix = {
    {0 ,20,INF,INF,20,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {20,0 ,30,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,30,0 ,20,INF,30,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,20,0 ,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {20,INF,INF,INF,0 ,10,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,30,INF,10,0 ,20,50,INF,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,20,0 ,40,10,INF,INF,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,50,40,0 ,INF,20,20,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,10,INF,0 ,20,INF,INF,INF,30,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,20,20,0 ,20,INF,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,20,INF,20,0 ,20,INF,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,0 ,10,INF,INF,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,10,0 ,INF,INF,20,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,30,INF,INF,INF,INF,0 ,20,INF,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,0 ,20,INF},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,20,INF,20,0 ,40},
    {INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,INF,40,0 }
    };
  */
                
        int begin=0;   
        int end=4;   
        graph.findCheapestPath(begin,end,matrix);   
        List< Integer> list=graph.result;   
        System.out.println(begin+" to "+end+",the cheapest path is:");   
        System.out.println(list.toString());   
        System.out.println(graph.dist[begin][end]);   
    }   
  
    public  void findCheapestPath(int begin,int end,int[][] matrix){   
        floyd(matrix);   
        result.add(begin);   
        findPath(begin,end);   
        result.add(end);   
    }   
       
    public List<Integer> findPath(int i,int j){ 
    	List< Integer> result2=new ArrayList< Integer>(); 
        int k=path[i][j];   
        if(k==-1)return null;   
        findPath(i,k);   //递归
        result2.add(k);   
        findPath(k,j); 
        return result2;
    }   
    public static  void floyd(int[][] matrix){   
        int size=matrix.length;   
        //initialize dist and path   
        for(int i=0;i< size;i++){   
            for(int j=0;j< size;j++){   
                path[i][j]=-1;   
                dist[i][j]=matrix[i][j];   
            }   
        }   
        for(int k=0;k< size;k++){   
            for(int i=0;i< size;i++){   
                for(int j=0;j< size;j++){   
                    if(dist[i][k]!=INF&&   
                        dist[k][j]!=INF&&   
                        dist[i][k]+dist[k][j]< dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];   
                        path[i][j]=k;   
                    }   
                }   
            }   
        }   
           
    }   
       
    public a09201(int size){   
        this.path=new int[size][size];   
        this.dist=new int[size][size];   
    }
    
    
    public static int f(a09201 g,int[][] adj){
    	int ret = 0;
    	floyd(adj);
    	for(int i=0;i<adj.length;i++){
    		for(int j=i+1;j<adj[0].length;j++){
    			if(adj[i][j]!=0){
    				
    				int[][] temp = adj;
    				int index1 = i;int index2 = j;
    				
    				while(path[index1][index2]!=0){
    					for(int k=0;k<temp[0].length;k++){
    						temp[index1][k] = 0;temp[index2][k] = 0;
    					}
    					for(int k=0;k<temp[0].length;k++){
    						temp[k][index1] = 0;temp[k][index2] = 0;
    					}
    					int t = index2;
    					index2 = path[index1][index2];
    					index1 = t;
    				}
    				int[][] a ;
    				if(temp.equals(a))
    					ret++;
    			}
    				
    		}
    	}
    	return ret;
    }
}