package com.hhlzr.easy;

public class _617_MergeTwoBinaryTrees {
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
	public int getVal(TreeNode t1, TreeNode t2){
		
		return t1.val + t2.val;
	}
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1==null & t2==null)
			return null;
		if(t1==null)
			return t2;
		if(t2==null)
			return t1;
		TreeNode ret = new TreeNode(0);
		ret.val = getVal(t1,t2);
		ret.left = mergeTrees(t1.left,t2.left);
		ret.right = mergeTrees(t1.right,t2.right);
		return ret;
        
    }
}
