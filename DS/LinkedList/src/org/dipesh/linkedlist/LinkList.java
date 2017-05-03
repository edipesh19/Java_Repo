package org.dipesh.linkedlist;

public class LinkList {

	public ListNode head;
	private int counter = 0;
	private ListNode nth;

	public LinkList() {
		head = null;
	}

	/**
	 * Insert front
	 */
	public void insertFront(int data) {
		ListNode newNode = new ListNode(data);
		newNode.next = head;
		head = newNode;
	}

	/**
	 * Insert end
	 */
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

	/**
	 * Reverse recursion
	 */
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

	/**
	 * Reverse iterative
	 */
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

	/**
	 * Find nth node from end iterative
	 */
	public ListNode finNthFromEnd(int n) {

		ListNode nth = head, last = head;
		for (int i = 0; i < n; i++) {
			if (last != null) {
				last = last.next;
			} else {
				return null;
			}
		}
		while (last != null) {
			last = last.next;
			nth = nth.next;
		}
		return nth;
	}

	/**
	 * Find nth node from end recursive
	 */
	public ListNode finNthFromEndRecursive(ListNode h, int n) {
		if (h == null) {
			return null;
		}

		finNthFromEndRecursive(h.next, n);
		counter++;
		if (counter == n) {
			nth = h;
		}
		return nth;

	}

	/**
	 * If loop exists in the list
	 */
	public boolean isLoopExists() {
		boolean loopExists = false;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				loopExists = true;
				break;
			}
		}
		return loopExists;
	}

	/*---------------------------------------------------------------------*/
	/*						  Utility Methods							   */
	/*---------------------------------------------------------------------*/

	/**
	 * Print list
	 */
	public void print() {
		ListNode p, q;
		for (p = head; (q = p.next) != null; p = q) {
			System.out.print("" + p.data + " -> ");
		}
		System.out.println(p.data);

	}

}
