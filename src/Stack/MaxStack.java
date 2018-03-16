package Stack;

import java.util.Stack;

public class MaxStack {
	Stack<Integer> stack;
	Stack<Integer> maxStack;
	public MaxStack() {
		stack = new Stack<>();
		maxStack = new Stack<>();
	}

	public void push(int x) {
		stack.push(x);
		Stack<Integer> tempStack = new Stack<>();
		
		while(!maxStack.isEmpty() && maxStack.peek()>x) {
			tempStack.push(maxStack.pop());
		}
		maxStack.push(x);
		while(!tempStack.isEmpty()) {
			maxStack.push(tempStack.pop());
		}
	}

	public int pop() {
		int x = stack.pop();
		Stack<Integer> tempStack = new Stack<>();

		while(!maxStack.isEmpty() && maxStack.peek()!=x) {
			tempStack.push(maxStack.pop());
		}
		maxStack.pop();
		while(!tempStack.isEmpty()) {
			maxStack.push(tempStack.pop());
		}
		return x;
	}

	public int top() {
		return stack.peek();
	}

	public int peekMax() {
		return maxStack.peek();
	}

	public int popMax() {
		int x = maxStack.pop();
		Stack<Integer> tempStack = new Stack<>();
		while(!stack.isEmpty() && stack.peek()!=x) {
			tempStack.push(stack.pop());
		}
		stack.pop();
		while(!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
		return x;
	}
	public static void main(String[] args) {
		MaxStack obj = new MaxStack();
		obj.push(5);
		obj.push(1);
		obj.push(5);
		System.out.println(obj.top());
		System.out.println(obj.popMax());
		System.out.println(obj.top());
		System.out.println(obj.peekMax());
		System.out.println(obj.pop());
		System.out.println(obj.top());
		["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
	}

}
