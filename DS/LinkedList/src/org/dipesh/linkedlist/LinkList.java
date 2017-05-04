package org.dipesh.linkedlist;

public class LinkList {

	public ListNode head;
	private int counter = 0;
	private ListNode nth;
	private ListNode thirdNode;

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

	/**
	 * Find the start node in the loop if there is a loop exists
	 */
	public ListNode findTheStartOfTheLoop() {
		ListNode fast = head;
		ListNode slow = head;
		boolean loopExists = false;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				loopExists = true;
				break;
			}
		}
		if (loopExists) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		} else {
			return null;
		}
	}

	/**
	 * Find the length of the loop
	 */
	public int lengthOfTheLoop() {

		boolean loopExists = false;
		int length = -1;
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
		if (loopExists) {
			do {
				slow = slow.next;
				length++;
			} while (slow != fast);
		}

		return length;

	}

	// --------------- Need to Test ----------------
	/**
	 * Insert a node in the sorted list
	 */
	public void inserNodeInTheSortedList(int data) {
		ListNode temp = head;
		ListNode prev = null;
		while (temp != null && data > temp.data) {
			prev = temp;
			temp = temp.next;
		}
		ListNode newNode = new ListNode(data);
		prev.next = newNode;
		newNode.next = temp;

	}

	/**
	 * Find the merge point of 2 list
	 */
	public ListNode findMergPointOfTwoList(ListNode list1, ListNode list2) {
		ListNode q, p, ret = null;
		int lenthOfList1 = 0;
		int lenthOfList2 = 0;
		int diff = 0;
		for (p = list1; (q = p.next) != null; p = q) {
			lenthOfList1++;
		}
		for (p = list2; (q = p.next) != null; p = q) {
			lenthOfList2++;
		}
		if (lenthOfList1 > lenthOfList2) {
			p = list2;
			q = list1;
			diff = lenthOfList1 - lenthOfList2;
		} else {
			p = list1;
			q = list2;
			diff = lenthOfList2 - lenthOfList1;
		}
		for (int i = 0; i < diff; i++) {
			q = q.next;
		}
		while (p != null && q != null) {
			if (p == q) {
				ret = p;
				break;
			}
			p = p.next;
			q = q.next;
		}
		return ret;
	}

	/**
	 * Find the middle of the list
	 */
	public ListNode findTheMiddleOfTheList() {
		ListNode ret = null;
		ListNode slow = head;
		ListNode fast = head;
		if (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ret = slow;
		return ret;
	}

	/**
	 * Display the list from end
	 */
	public void displayReverse(ListNode h) {
		if (h == null) {
			return;
		}
		displayReverse(h.next);
		System.out.print(h.data + " -> ");
	}

	/**
	 * Merge two sorted list into a third list
	 */
	public ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null) {
			return list1;
		}
		if (list1.data <= list2.data) {
			thirdNode = list1;
			thirdNode.next = mergeTwoSortedList(list1.next, list2);
		} else {
			thirdNode = list2;
			thirdNode.next = mergeTwoSortedList(list1, list2.next);
		}
		return thirdNode;
	}

	/**
	 * Merge two sorted list into a third list iterative
	 */
	public ListNode mergeTwoSortedListIterative(ListNode list1, ListNode list2) {
		ListNode newNode = null;
		ListNode current = null;
		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				if (newNode == null) {
					newNode = list1;
					current = newNode;

				} else {
					current.next = list1;
				}
				list1 = list1.next;

			} else {
				if (newNode == null) {
					newNode = list2;
					current = newNode;
				} else {
					current.next = list2;
				}
				list2 = list2.next;

			}
			current = current.next;
		}
		if (list1 == null){
			current.next = list2;
		} else{
			current.next = list1;
		}
		return newNode;
	}

	public ListNode reverseLinkListInPair(ListNode h){
		ListNode temp;
		if (h == null) {
			return null;
		}
		// Swap 2 node
		temp = h.next;
		h.next = temp.next;
		temp.next = h;
		h = temp;
		if (h.next != null) {
			h.next.next = reverseLinkListInPair(h.next.next);
		}
		return h;
	}

	public ListNode reverseLinkListInPairIterative (ListNode h) {
		ListNode temp = null;
		ListNode ret = null;
		while(h != null && h.next != null){
			if (temp == null){
				ret = h.next;
			}
			temp = h.next;
			h = temp.next;
			temp.next = h;
			h = h.next;
		}
		return ret;
	}

	public ListNode reverseKNodesRecursively(ListNode head, int k){
		ListNode current = head;
		ListNode next = null;
		ListNode prev = null;
		int count = k;
		while(current != null && count > 0){
			next = current.next;
			current.next = prev;
			prev = current;
			current =next;
			count--;
		}
		while(next != null){
			head.next = reverseKNodesRecursively(next, k);
		}
		return prev;
	}

	public ListNode reverseKNodesIteratively(ListNode head, int k){
		return null;
	}
	/*---------------------------------------------------------------------*/
	/* Utility Methods */
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
