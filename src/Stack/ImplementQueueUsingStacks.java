package Stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {
	Stack<Integer> temp = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
	// Push element x to the back of queue.
    public void push(int x) {
    	while(!stack.isEmpty()){
        	temp.push(stack.peek());
        	stack.pop();
        }
    	stack.push(x);
        while(!temp.isEmpty()){
        	stack.push(temp.peek());
        	temp.pop();
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
