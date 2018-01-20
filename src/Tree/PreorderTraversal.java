package Tree;
import java.util.*;
public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
		actualTraversal(root, result);
		return result;
	}
	
	public void actualTraversal(TreeNode node, List<Integer> result){
		if(node==null) return;
		result.add(node.val);
		actualTraversal(node.left, result);
		actualTraversal(node.right, result);
	}
	
	public List<Integer> preorderTraversalIteration(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			if(node==null) continue;
			result.add(node.val);
			stack.push(node.right);
			stack.push(node.left);
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		PreorderTraversal testPreorderTraversal = new PreorderTraversal();
		System.out.println(testPreorderTraversal.preorderTraversalIteration(node));

	}

}
