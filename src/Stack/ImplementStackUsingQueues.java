package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	Queue<Integer> queue = new LinkedList<>();
	Queue<Integer> temp = new LinkedList<>();
	// Push element x onto stack.
    public void push(int x) {
        while(!queue.isEmpty()){
        	temp.add(queue.peek());
        	queue.poll();
        }
        queue.add(x);
        while(!temp.isEmpty()){
        	queue.add(temp.peek());
        	temp.poll();
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
