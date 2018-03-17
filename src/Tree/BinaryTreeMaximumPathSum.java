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
}
