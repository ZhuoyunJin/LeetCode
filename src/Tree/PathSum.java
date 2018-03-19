package Tree;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.left == null && root.right ==null)
			return root.val ==sum;
		return hasPathSum(root.left, sum-root.val)
				|| hasPathSum(root.right, sum-root.val);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}