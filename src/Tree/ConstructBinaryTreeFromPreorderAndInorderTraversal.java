package Tree;
import java.util.*;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	//preorder = [3,9,20,15,7]
	//inorder = [9,3,15,20,7]
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLen = preorder.length;
		int inLen = inorder.length;
		if(preLen != inLen || preLen ==0 ) return null;
		Map<Integer, Integer> inMap = new HashMap<>();
		for(int i=0;i<inLen;i++) {
			inMap.put(inorder[i],i);
		}
		return helper(preorder, inorder, inMap, 0, preLen-1, 0, inLen -1);
	}
	
	public TreeNode helper(int[] preorder, int[] inorder, Map<Integer, Integer> inMap, 
			int preStart, int preEnd, int inStart, int inEnd) {
		int val = preorder[preStart];
		TreeNode root = new TreeNode(val);
		if(preStart >= preEnd) return root;
		int positionInInorder = inMap.get(val);
		int numLeft = positionInInorder - inStart;
		int numRight = inEnd - positionInInorder;
		if(numLeft > 0)
			root.left = helper(preorder, inorder, inMap, preStart+1, preStart+numLeft, inStart, positionInInorder-1);
		if(numRight > 0)
			root.right = helper(preorder, inorder, inMap, preStart+numLeft+1, preEnd, positionInInorder+1, inEnd);;
		return root;
	}
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal test = 
				new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		test.buildTree(new int[] {1,2}, new int[] {2,1});
	}
}
