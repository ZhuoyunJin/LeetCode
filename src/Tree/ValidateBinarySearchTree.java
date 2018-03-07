package Tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}
	public boolean isValidBSTHelper(TreeNode root, int max, int min) {
		if(root == null) return true;
		if(root.val>=max || root.val<=min) return false;
		return isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max,root.val);
	}
	
	public boolean isValidBSTIteration(TreeNode root) {
		if(root == null) return true;
		List<Integer> list = new ArrayList<>();
		buildList(root, list);
		if(list.size() == 1) return true;
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i)>=list.get(i+1)) return false;
		}
		return true;
	}
	
	public void buildList(TreeNode root, List<Integer> list) {
		if(root.left!=null) buildList(root.left, list);
		list.add(root.val);
		if(root.right!=null) buildList(root.right, list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
