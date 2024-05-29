package com.practicesearchingalgorithms;

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}

public class RemoveDuplicates {
	public static void removeDuplicates(ListNode head) {
		if (head == null)
			return;
		ListNode current = head;
		while (current != null && current.next != null) {
			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
			
		}
	}
	public static void printList(ListNode head) {
		ListNode current=head;
		while(current!=null) {
			System.out.print(current.val+"");
			current=current.next;
		}
		System.out.println();
	}
	public static void main(String args[]) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(1);
		head.next.next=new ListNode(2);
		head.next.next.next=new ListNode(3);
		head.next.next.next.next=new ListNode(3);
		System.out.println("Original list:");
		printList(head);
		removeDuplicates(head);
		System.out.println("List after removing duplicates:");
		printList(head);
	}
}
