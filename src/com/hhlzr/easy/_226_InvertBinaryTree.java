package com.hhlzr.easy;

import java.util.Deque;
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
			TreeNode t = q1.poll();
			TreeNode temp = new TreeNode(0);
			temp = t.left;
			t.left = t.right;
			t.right = temp;
			if(t.left != null)
				q1.add(t.left);
			if(t.right != null)
				q1.add(t.right);
		}
		return root;
    }
    
    //My simple recursion java solution
    public TreeNode invertTree2(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    
    //Lets start with straightforward - recursive DFS
    public TreeNode invertTree3_1(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final TreeNode left = root.left,
                right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
    
    //The above solution is correct, but it is also bound to the application stack, 
    //which means that it's no so much scalable - (you can find the problem size that
    //will overflow the stack and crash your application), so more robust solution 
    //would be to use stack data structure.
    public TreeNode invertTree3_2(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
            final TreeNode node = stack.pop();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;
            
            if(node.left != null) {
                stack.push(node.left);
            }
            if(node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
    
    //Finally we can easly convert the above solution to BFS - or so called level
    //order traversal
    public TreeNode invertTree3_3(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
