package org.dipesh.linkedlist;

public class Client {

	public static void main(String[] args) {
		LinkList ll = new LinkList();

		fillList(ll);
		ll.print();

		ll.reverseRecursion(ll.head);
		ll.print();

		ll.reverseInterative();
		ll.print();

		ListNode node = ll.finNthFromEnd(2);

		System.out.println("2nd node from end = " + node.data);

		node = ll.finNthFromEndRecursive(ll.head, 3);

		System.out.println("3rd node from end = " + node.data);

		createLoopInLst(ll);
		if (ll.isLoopExists()) {
			System.out.println("Loop exists");
		} else {
			System.out.println("Loop does not exists");
		}

		node = ll.findTheStartOfTheLoop();
		System.out.println(node.data);

		System.out.println(ll.lengthOfTheLoop());

	}

	private static void createLoopInLst(LinkList ll) {
		ListNode fourthAddress = ll.head;
		ListNode head;
		for (int i = 0; i < 3; i++) {
			fourthAddress = fourthAddress.next;
		}
		head = fourthAddress;
		while (head.next != null) {
			head = head.next;
		}

		head.next = fourthAddress;

	}

	private static void fillList(LinkList ll) {
		ll.insertFront(4);
		ll.insertFront(3);
		ll.insertFront(2);
		ll.insertFront(1);
		ll.insertEnd(5);
		ll.insertEnd(6);
		ll.insertEnd(7);
		ll.insertEnd(8);
		ll.insertEnd(9);
		ll.insertEnd(10);
	}

}
