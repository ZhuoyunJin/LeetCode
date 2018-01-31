package Tree;

public class DiameterOfBinaryTree {
	public int diameterOfBinaryTree(TreeNode root) {
		if(root == null) return 0;
		int[] rev = helper(root);
		return rev[1];
	}
	
	public int[] helper(TreeNode node){
		int leftLevel=0, rightLevel=0;
		int leftDiameter=0, rightDiameter=0;
		if(node.left!=null){
			int[] arr = helper(node.left);
			leftLevel+=arr[0]+1;
			leftDiameter += arr[1];
		}
		
		if(node.right!=null){
			int[] arr = helper(node.right);
			rightLevel+=arr[0]+1;
			rightDiameter += arr[1];
		}
		
		int max = Math.max(Math.max(rightDiameter, leftDiameter), leftLevel+rightLevel);
		int level = Math.max(leftLevel, rightLevel);
		int[] ret = new int[]{level, max};
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
