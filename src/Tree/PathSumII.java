package Tree;
import java.util.*;
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		helper(root, sum, list, new ArrayList<Integer>());
		return list;
	}

	public void helper(TreeNode root, int sum, List<List<Integer>> list, List<Integer> tempList) {
		if(root == null) return;
		tempList.add(root.val);
		sum = sum - root.val;
		if(root.left == null && root.right == null) {
			if(sum == 0) {
				List<Integer> newList = new ArrayList<>();
				for(int i=0; i<tempList.size(); i++) {
					newList.add(tempList.get(i));
				}
				list.add(newList);
			}
		}else{
			helper(root.left, sum, list, tempList);
			helper(root.right, sum, list, tempList);
		}
		tempList.remove(tempList.size()-1);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left  = new TreeNode(-2);
		node.right = new TreeNode(-3);
		node.left.left  = new TreeNode(1);
		node.left.right  = new TreeNode(3);
		node.right.right  = new TreeNode(-2);
		PathSumII sum = new PathSumII();
		System.out.println(sum.pathSum(node, 2));
	}

}
