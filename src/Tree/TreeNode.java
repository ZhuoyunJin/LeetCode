package Tree;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	public static TreeNode buildTree(int[] arr){
		int len = arr.length;
		if(len ==0) return null;
		return buildTreeHelper(arr, 0, len-1);
	}
	
	public static TreeNode buildTreeHelper(int[] arr, int start, int end){
		if(start<end) return null;

		int mid = (start+end)/2;
		TreeNode treeNode = new TreeNode(arr[mid]);
		treeNode.left=buildTreeHelper(arr, 0, mid-1);
		treeNode.right = buildTreeHelper(arr, mid+1, arr.length-1);
		return treeNode;
	}
}

