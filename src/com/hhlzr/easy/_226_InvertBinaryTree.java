package com.hhlzr.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _226_InvertBinaryTree {
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
    public TreeNode invertTree(TreeNode root) {
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
		q1.add(root);
		while (q1.peek()!=null) {
			int len = q1.size();
			for(int i=0;i<len;i++){
				TreeNode t = q1.poll();
				if(t.left!=null & t.right!=null){
					TreeNode temp = new TreeNode(0);
					temp = t.left;
					t.left = t.right;
					t.right = temp;
					q1.add(t.left);
					q1.add(t.right);
				}else if(t.left==null & t.right != null){
					t.left = t.right;
					t.right = null;
					q1.add(t.left);
				}else if(t.left!=null & t.right == null){
					t.right = t.left;
					t.left = null;
					q1.add(t.right);
				}
			}
		}
		return root;
    }
}
