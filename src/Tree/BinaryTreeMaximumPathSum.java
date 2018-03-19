package Tree;

public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
		if(root==null) return 0;
		int[] max={Integer.MIN_VALUE};
		int x=findMax(root, max);
		return Math.max(x,max[0]);
	}

	public int findMax(TreeNode root, int[] max){
		if(root==null) return Integer.MIN_VALUE/3;
		int leftMax = findMax(root.left, max);
		int rightMax = findMax(root.right, max);
		int subMax = Math.max(leftMax, rightMax);
		max[0]= subMax>max[0]?subMax:max[0];
		max[0]= (root.val+leftMax+rightMax)>max[0]?(root.val+leftMax+rightMax):max[0];
		return Math.max(root.val, Math.max(rightMax+root.val, leftMax+root.val));
	}

	int max=Integer.MIN_VALUE;
	public int maxPathSum2(TreeNode root) {
		helper(root);
		return max;
	}

	public int helper(TreeNode root) {
		if(root == null) return Integer.MIN_VALUE;
		int leftMax = helper(root.left);
		int rightMax = helper(root.right);
		leftMax = leftMax>0?leftMax:0;
		rightMax = rightMax>0?rightMax:0;
		int retValue = Math.max(leftMax, rightMax) +root.val;
		max = Math.max(max, leftMax+rightMax+root.val);
		//System.out.println(retValue);
		return retValue;
	}
	
	public static void main(String[] args) {
		BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(test.maxPathSum2(root));
	}
}
