package Tree;


public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) {
        TreeNode tn1 = null;
        TreeNode tn2 = null;
        recoverTree(root, tn1, tn2);
    }
	
	public void recoverTree(TreeNode root, TreeNode tn1, TreeNode tn2){
		if(root==null) return;
	}
}

