package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
	Queue<Integer> queue;
    public ImplementStackUsingQueues() {
        this.queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
       queue.add(x);
       int size = queue.size();
       for(int i=0;i<size-1;i++){
    	   queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public int pop() {
        return queue.poll();
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
