package com.hhlzr.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class _637_AverageofLevelsinBinaryTree {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { 
	    	  val = x; 
	      }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<Double>();
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q1.add(root);
		double sum = 0.0;
		double len = 0.0;
		TreeNode t = new TreeNode(0);
		while (true) {
			sum = 0.0;
			len = 0.0;
			while(q1.peek()!=null){
				t = q1.poll();
				sum += t.val;
				len++;
				if(t.left!=null)
					q2.add(t.left);
				if(t.right!=null)
					q2.add(t.right);
			}
			ret.add(sum/len);
			q1.addAll(q2);
			if(q2.peek()==null)
				break;
			else
				q2.clear();
		}
		return ret;
    }
	//use one queue BFS
    public List<Double> averageOfLevels2(TreeNode root) {
    	List<Double> ret = new ArrayList<Double>();
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        if(root == null) return ret;
		q1.add(root);
		while (!q1.isEmpty()) {
			double sum = 0.0;
			double len = q1.size();
			for(int i=0;i<len;i++){
				TreeNode t = q1.poll();
				sum += t.val;
				if(t.left!=null)
					q1.add(t.left);
				if(t.right!=null)
					q1.add(t.right);
			}
			ret.add(sum/len);
		}
		return ret;
    }
}
