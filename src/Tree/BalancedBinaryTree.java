package Tree;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		return isBalancedHelper(root, 0) >= 0;
	}
	
	public int isBalancedHelper(TreeNode root, int level) {
		if(root == null) return level;
		int leftHeight = isBalancedHelper(root.left, level+1);
		int rightHeight = isBalancedHelper(root.right, level+1);
		if(rightHeight < 0 || leftHeight < 0)
			return -1;
		if(Math.abs(leftHeight-rightHeight) > 1)
			return -1;
		else
			return Math.max(leftHeight, rightHeight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
