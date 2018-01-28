package Stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	/** Initialize your data structure here. */
	Stack<Integer> stack;
	public ImplementQueueUsingStacks() {
		this.stack = new Stack<Integer>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		Stack<Integer> tempStack = new Stack<Integer>();
		int size = stack.size();
		for(int i=0;i<size;i++){
			tempStack.push(stack.pop());
		}
		stack.push(x);
		size = tempStack.size();
		for(int i=0;i<size;i++){
			stack.push(tempStack.pop());
		}
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		return stack.pop();   
	}

	/** Get the front element. */
	public int peek() {
		return stack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return stack.isEmpty();
	}
	
	public static void main(String[] args){
		ImplementQueueUsingStacks implementQueueUsingStacks = new ImplementQueueUsingStacks();
		implementQueueUsingStacks.push(1);
		implementQueueUsingStacks.push(2);
		implementQueueUsingStacks.push(3);
		System.out.println(implementQueueUsingStacks.pop());
		System.out.println(implementQueueUsingStacks.pop());
		System.out.println(implementQueueUsingStacks.pop());
//		System.out.println(implementQueueUsingStacks.peek());
	}
}
