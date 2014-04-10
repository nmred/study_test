package test07;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList booksLinkedList = new LinkedList();
		booksLinkedList.offer("疯狂Java讲义");
		booksLinkedList.offer("轻量级Java EE企业应用实战");
		booksLinkedList.offer("疯狂Android讲义");
		for (int i = 0; i < booksLinkedList.size(); i++) {
			System.out.println(booksLinkedList.get(i));
		}
		System.out.println(booksLinkedList.peekFirst());
		System.out.println(booksLinkedList.peekLast());
		System.out.println(booksLinkedList.pop());
		System.out.println(booksLinkedList);
		System.out.println(booksLinkedList.pollLast());
		System.out.println(booksLinkedList);
	}
}
