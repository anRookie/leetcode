package com.hhlzr.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _653_TwoSumIVInputisaBST {
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> nums = new HashSet<>();
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        if(root == null) return false;
		q1.add(root);
		while (!q1.isEmpty()) {
			TreeNode t = q1.poll();
			if(nums.contains(k-t.val))
				return true;
			nums.add(t.val);
			if(t.left!=null)
				q1.add(t.left);
			if(t.right!=null)
				q1.add(t.right);
		}
        return false;
    }
}
