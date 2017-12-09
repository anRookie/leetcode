package com.hhlzr.easy;

import common.ListNode;

public class _21_MergeTwoSortedLists {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
//		l1.next = new ListNode(4);
//		l1.next.next = new ListNode(6);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next = new ListNode(4);

		System.out.println(mergeTwoLists(l1,l2));
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null && l2==null)
			return null;
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		ListNode ret = new ListNode(0);
		if(l1.val>l2.val){
			ret = l2;
			l2 = l2.next;
		}else{
			ret = l1;
			l1 = l1.next;
		}
		ListNode head = ret;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){
				ret.next = l1;
				l1 = l1.next;
			}else{
				ret.next = l2;
				l2 = l2.next;
			}
			ret = ret.next;
		}
		if(l1!=null)
			ret.next = l1;
		if(l2!=null)
			ret.next = l2;
		return head;
	}
}
