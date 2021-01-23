package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Tree.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> currentList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == null) {
                if(result.size()%2 == 1) {
                    Collections.reverse(currentList);
                }
                result.add(currentList);
                currentList = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);
            } else {
                currentList.add(currentNode.val);
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        if(!currentList.isEmpty()) result.add(currentList);
        return result;
    }
}
