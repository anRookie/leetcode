package com.hhlzr.easy;

public class _236_LowestCommonAncestorofaBinaryTree {
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
//	static String[] codes = new String[2];
//    static int codesi = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	String tcode = "0";
    	String code1 = "",code2 = "";
    	int pval = p.val,qval = q.val;
    	String[] codes = new String[3];
    	codes[2] = "0";
    	codes = dfs(root,pval,qval,tcode,codes);
    	code1 = codes[0];code2 = codes[1];
    	System.out.println(code1);
        System.out.println(code2);
    	int i = 0;
    	String anccode = "";
    	while (i<Math.min(code1.length(), code2.length())) {
    		if(code1.charAt(i)==code2.charAt(i))
    			anccode += code1.charAt(i++);
    		else
    			break;
		}
        System.out.println(anccode);
    	i = 1;
    	TreeNode ret = root;
    	while(i<anccode.length()){
    		if(anccode.charAt(i)=='0')
    			ret = ret.left;
    		if(anccode.charAt(i)=='1')
    			ret = ret.right;
            i++;
    	}
        return ret;
    }
    
    public String[] dfs(TreeNode t,int pval,int qval,String tcode,String[] codes){
//    	System.out.println(codesi);
    	if(t.val == pval | t.val == qval){
            if("0".equals(codes[2])){
            	codes[0] = tcode;
            	codes[2] = "1";
            }else if("1".equals(codes[2])){
            	codes[1] = tcode;
            	codes[2] = "2";
            }
		}
		if(t.left!=null){
			dfs(t.left,pval,qval,tcode+"0",codes);
		}
		if(t.right!=null){
			dfs(t.right,pval,qval,tcode+"1",codes);
		}
		return codes;
		
    }
    
    
    //other's Solution which is easy to understand
    public class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q)  return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left != null && right != null)   return root;
            return left != null ? left : right;
        }
    }
}
