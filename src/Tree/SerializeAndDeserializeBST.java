package Tree;
import java.util.*;
public class SerializeAndDeserializeBST {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, List<Integer>> map = new HashMap<>();
		helper(root, 0, map);
		
		int levels = map.size();
		for(int i=0; i<levels; i++) {
			List<Integer> list = map.get(i);
			for(Integer val : list) {
				sb.append(val ==null?"#":val);
			}
		}
		return sb.toString();
	}

	public void helper(TreeNode root, int level, Map<Integer, List<Integer>> map) {
		List<Integer> list = map.getOrDefault(level, new LinkedList<Integer>());
		if(root == null) list.add(null);
		else list.add(root.val);
		
	}

	// Decodes your encoded data to tree.
	//public TreeNode deserialize(String data) {

	//}
	public static void main(String[] args) {

		SerializeAndDeserializeBST test = new SerializeAndDeserializeBST();
		String s =test.serialize(new TreeNode(3));
		System.out.println(s);
	}

}
