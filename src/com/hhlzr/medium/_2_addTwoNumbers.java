package com.hhlzr.medium;

import java.util.ArrayList;
import java.util.List;

public class _2_addTwoNumbers {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode getListNode(int val) {
		return new ListNode(val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_2_addTwoNumbers atn = new _2_addTwoNumbers();
		int[] l1arr = {3,1 };
		int[] l2arr = {3 };
		ListNode l1 = atn.getListNode(0);
		ListNode l1first = l1;
		ListNode l2 = atn.getListNode(0);
		ListNode l2first = l2;
		for (int i = 0; i < l1arr.length; i++) {
			ListNode l1new = atn.getListNode(l1arr[i]);
			if (i == 0) {
				l1.val = l1arr[i];
			} else {
				l1.next = l1new;
				l1 = l1.next;
			}
			System.out.println("initl1:" + l1.val);
		}
		for (int i = 0; i < l2arr.length; i++) {
			ListNode l2new = atn.getListNode(l2arr[i]);
			if (i == 0) {
				l2.val = l2arr[i];
			} else {
				l2.next = l2new;
				l2 = l2.next;
			}
			System.out.println("initl2:" + l2.val);
		}
		ListNode l3 = atn.solutions(l1first, l2first);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
	}

	public ListNode solutions(ListNode l1, ListNode l2) {
		ListNode l3 = new ListNode(0);
		ListNode l3first = l3;
		int add = 0;
		while(true){
			ListNode newNode = new ListNode(0);
			if (l1 == null && l2 != null)
				newNode.val = l2.val + add;
			else if (l1 != null && l2 == null)
				newNode.val = l1.val + add;
			else if (l1 == null && l2 == null && add==1){
				newNode.val = add;
				l3.next = newNode;
				l3 = l3.next;
				break;
			}else if (l1 == null && l2 == null && add==0){
				break;
			}
			else
				newNode.val = l1.val + l2.val + add;
			if (newNode.val>=10){
				newNode.val-=10;
				add = 1;
			}
			else
				add = 0;
			if (l1 == null && l2 != null){
				System.out.println("l2.val:"+l2.val);
				l2 = l2.next;
			}
			else if (l1 != null && l2 == null){
				System.out.println("l1.val:"+l1.val);
				l1 = l1.next;
				
			}
			else {
				System.out.println("l1.val:"+l1.val);
				System.out.println("l2.val:"+l2.val);
				l1 = l1.next;
				l2 = l2.next;
			}
			System.out.println("add:"+add);
			System.out.println("newNode:"+newNode.val);
			l3.next = newNode;
			l3 = l3.next;
		}
		return l3first.next;
	}
	
	/*Java Solution beats 99.6% which is lucid and readable
	 * public class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode head1 = l1;
	        ListNode head2 = l2;
	        ListNode dummy = new ListNode(0);
	        ListNode head = dummy;
	        int carry = 0;
	        while (head1 != null || head2 != null || carry != 0){
	            int val = carry;
	            if (head1 != null){
	                val += head1.val;
	                head1 = head1.next;
	            }
	            if (head2 != null){
	                val += head2.val;
	                head2 = head2.next;
	            }
	            ListNode tmp = new ListNode(val%10);
	            carry = val/10;
	            head.next = tmp;
	            head = head.next;
	        }
	        return dummy.next;
	    }
	}*/
}
