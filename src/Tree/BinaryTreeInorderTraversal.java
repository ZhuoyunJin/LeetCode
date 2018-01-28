package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recurser(root, result);
        return result;
    }
	
	public void recurser(TreeNode root, List<Integer> list){
		if(root!=null){
			recurser(root.left, list);
			list.add(root.val);
			recurser(root.right, list);
		}
	}
	
	//iteratively
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        if(root == null) return result;
        stack.push(root);
        map.put(root.hashCode(), 0);
        while(!stack.isEmpty()){
        	TreeNode node=stack.peek();
        	if(node==null) {
        		stack.pop();
        		continue;
        	}
        	if(map.containsKey(node.hashCode())&&map.get(node.hashCode())==1){
        		result.add(node.val);
        		stack.add(node.right);
        		map.put(node.hashCode(), 2);
        	}else if(map.containsKey(node.hashCode())&&map.get(node.hashCode())==0){
        		stack.add(node.left);
        		map.put(node.hashCode(), 1);
        	}else if(!map.containsKey(node.hashCode())){
        		map.put(node.hashCode(), 0);
        	}else{
        		stack.pop();
        	}
        }
        return result;
    }

	public List<Integer> inorderTraversal3(TreeNode root) {
		if(root==null) return null;
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	if(stack.peek().left!=null){
        		stack.push(stack.peek().left);
        	}else{
        		result.add(stack.peek().val);
        		
        	}
        }
        return result;
	}
}
