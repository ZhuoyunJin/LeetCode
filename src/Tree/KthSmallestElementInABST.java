package Tree;

public class KthSmallestElementInABST {
	int counter = 0;
	public int kthSmallest(TreeNode root, int k) {
		return kthSmallestHelper(root, k).val;
	}

	public TreeNode kthSmallestHelper(TreeNode root, int k) {
		if(root==null) return null;
		TreeNode node;
		node = kthSmallestHelper(root.left, k);
		if(node != null) return node;
		if(++counter == k)
			return root;
		node = kthSmallestHelper(root.right, k);
		if(node != null) return node;
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
