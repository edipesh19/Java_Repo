package org.dipesh.linkedlist;

public class LinkList {

	public ListNode head;

	public LinkList() {
		head = null;
	}

	public void insertFront(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}

	public void insertEnd(int data) {
		ListNode newNode = new ListNode(data);
		if (head == null) {
			head = newNode;
		} else {
			ListNode p, q;
			for (p = head; (q = p.next) != null; p = q)
				;
			p.next = newNode;
		}
	}

	public void print() {
		ListNode p, q;
		for (p = head; (q = p.next) != null; p = q) {
			System.out.print("" + p.data + " -> ");
		}
		System.out.println(p.data);

	}

	public ListNode reverseRecursion(ListNode h) {
		if (h == null) {
			return h;
		}
		ListNode prev = reverseRecursion(h.next);

		if (null == prev) {
			head = h;
		} else {
			prev.next = h;
			h.next = null;
		}
		return h;
	}

	public void reverseInterative() {
		ListNode prev, next, current;
		prev = null;
		current = head;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

}
