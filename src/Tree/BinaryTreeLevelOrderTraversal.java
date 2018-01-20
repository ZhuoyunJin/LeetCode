package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		traversalHelper(list,root, 0);
		return list;
	}
	public void traversalHelper(List<List<Integer>> list, TreeNode node, int level){
		if(node == null) return;
		if(list.size() > level){
			list.get(level).add(node.val);
		}
		else{
			List<Integer> subList = new ArrayList<Integer>();
			subList.add(node.val);
			list.add(subList);
		}
		traversalHelper(list, node.left, level+1);
		traversalHelper(list, node.right, level+1);
	}
}
