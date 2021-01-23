package BFS;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> currentQueue = new LinkedList<>();
        currentQueue.add(root);
        Queue<Node> nextQueue = new LinkedList<>();

        while(!currentQueue.isEmpty()){
            Node currentNode = currentQueue.poll();
            currentNode.next = currentQueue.isEmpty() ? null : currentQueue.peek();
            if(currentNode.left != null) {
                nextQueue.add(currentNode.left);
                nextQueue.add(currentNode.right);
            }
            if(currentQueue.isEmpty() && nextQueue.isEmpty()) {
                return root;
            } else if(currentQueue.isEmpty()) {
                currentQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }

        }
        return root;
    }
}
