package test07;

import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.offer(6);
		pq.offer(-3);
		pq.offer(9);
		pq.offer(0);
		
		System.out.print(pq);
		System.out.println(pq.poll());
	}
}
