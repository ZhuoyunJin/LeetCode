package Tree;

import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	//inorder = [9,3,15,20,7]
	//postorder = [9,15,7,20,3]
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i< inorder.length; i++) {
			map.put(inorder[i], i)
;		}
		return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1, map);
	}
	
	public TreeNode helper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd,
			int postorderStart, int postorderEnd, Map<Integer, Integer> map ) {
		if(postorderStart > postorderEnd ) return null;
		int valRoot = postorder[postorderEnd];
		TreeNode root = new TreeNode(valRoot);
		int position = map.get(valRoot);
		int leftNodes = position - inorderStart;
		int rightNotes = inorderEnd - position;
		if(leftNodes > 0)
			root.left=helper(inorder, postorder, inorderStart, position-1, postorderStart, postorderStart+leftNodes-1, map);
		if(rightNotes > 0)
			root.right=helper(inorder, postorder, position+1, inorderEnd, postorderStart+leftNodes, postorderEnd-1, map);
		
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
