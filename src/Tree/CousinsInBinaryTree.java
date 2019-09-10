package Tree;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> parents = new HashMap<>();
        Map<Integer, Integer> depths = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        depths.put(root.val, 1);
        parents.put(root.val, null);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left!=null) {
                queue.add(node.left);
                parents.put(node.left.val, node.val);
                depths.put(node.left.val, depths.get(node.val)+1);
            }
            if(node.right!=null) {
                queue.add(node.right);
                parents.put(node.right.val, node.val);
                depths.put(node.right.val, depths.get(node.val)+1);
            }
        }
        return ((parents.get(x) != parents.get(y)) && (depths.get(x) == depths.get(y)));
    }
}
