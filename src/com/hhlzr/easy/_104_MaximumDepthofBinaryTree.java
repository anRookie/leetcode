package com.hhlzr.easy;

import java.util.LinkedList;
import java.util.Queue;


public class _104_MaximumDepthofBinaryTree {
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
    public int maxDepth(TreeNode root) {
    	int ret = 1;
		Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        if(root == null) return 0;
		q1.add(root);
		while (!q1.isEmpty()) {
			int len = q1.size();
			for(int i=0;i<len;i++){
				TreeNode t = q1.poll();
				if(t.left!=null)
					q1.add(t.left);
				if(t.right!=null)
					q1.add(t.right);
			}
			ret++;
		}
		return ret;
    }
}
