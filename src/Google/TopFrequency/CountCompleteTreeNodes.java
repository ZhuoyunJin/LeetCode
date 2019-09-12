package Google.TopFrequency;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root){
        if(root == null) return 0;
        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);
        if(leftHeight == rightHeight) {
            return (int)Math.pow(2, rightHeight+1)-1;
        }
        else{
            return 1+ countNodes(root.left) + countNodes(root.right);
        }
    }

    public int getRightHeight(TreeNode root){
        if(root == null) return 0;
        return getRightHeight(root.right) + 1;
    }

    public int getLeftHeight(TreeNode root){
        if(root == null) return 0;
        return getLeftHeight(root.left) + 1;
    }

    public int countNodesNaive(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            count++;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return count;
    }
}
