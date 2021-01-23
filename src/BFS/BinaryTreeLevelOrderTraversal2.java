package BFS;
import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<Integer> currentList = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == null){
                result.add(currentList);
                currentList = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);
            } else {
                currentList.add(currentNode.val);
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
        }
        if (!currentList.isEmpty()) result.add(currentList);
        Collections.reverse(result);
        return result;
    }
}
