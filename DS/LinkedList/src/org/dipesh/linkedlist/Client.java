package org.dipesh.linkedlist;


public class Client {

	public static void main(String[] args) {
		LinkList ll = new LinkList();
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

		ll.print();

		ll.reverseRecursion(ll.head);

		ll.print();

		ll.reverseInterative();
		ll.print();

	}

}
