package com.practicesortingalgorithms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueSorting {
	public static void sortQueue(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			int current = queue.poll();
			while (!stack.isEmpty() && stack.peek() > current) {
				queue.add(stack.pop());
			}
			stack.push(current);
		}
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
	}
	public static void main(String args[]) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(34);
		queue.add(3);
		queue.add(31);
		queue.add(98);
		queue.add(92);
		queue.add(23);
		System.out.println("UnSorted queue:"+queue);
		sortQueue(queue);
		System.out.println("Sorted queue:"+queue);
	}
}
