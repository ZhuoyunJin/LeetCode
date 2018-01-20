package Google;

public class ClosestBinarySearchTreeValue {
	public int closestValue(TreeNode root, double target) {
		return helper(root, target);
	}
	
	public int helper(TreeNode node, double target){
		int sideClosest;
		if(target<node.val && node.left!=null){
			sideClosest = helper(node.left, target);
		}else if(target>node.val && node.right!=null){
			sideClosest = helper(node.right, target);
		}else{
			return node.val;
		}
		double diffRoot = Math.abs(node.val-target);
		double diffSide = Math.abs(sideClosest-target);
		return diffRoot<diffSide?node.val:sideClosest;
	}
}
