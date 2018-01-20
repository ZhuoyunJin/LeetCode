package Google;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list= new ArrayList<String>();
		if(root == null)
			return list;
		else
			list = helper(root);
		return list;
	}
	
	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> list= new ArrayList<String>();
		if(root == null)
			return list;
		else
			helper2(root, ""+root.val, list);
		return list;
	}

	public List<String> helper(TreeNode node){
		List<String> list= new ArrayList<String>();
		if(node.left==null && node.right==null){
			list.add("");
		}
		if(node.left!=null){
			list.addAll(helper(node.left));
		}
		if(node.right!=null){
			list.addAll(helper(node.right));
		}
		List<String> ret= new ArrayList<String>();
		for(String str:list){
			if(str.equals(""))
				ret.add(""+node.val);
			else
				ret.add(""+node.val+"->"+str);
		}
		return ret;
	}

	public void helper2(TreeNode node, String string, List<String> list){
		if(node.left==null && node.right == null){
			list.add(string);
		}
		if(node.left!=null){
			helper2(node.left, string+"->"+node.left.val, list);
		}
		if(node.right!=null){
			helper2(node.right, string+"->"+node.right.val, list);
		}
	}
}
