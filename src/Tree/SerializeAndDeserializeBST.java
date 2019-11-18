package Tree;
import java.util.*;
public class SerializeAndDeserializeBST {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		serializeHelper(root, list);
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<list.size();i++){
			sb.append(list.get(i));
			sb.append(",");
		}
		return sb.toString();
	}

	public void serializeHelper(TreeNode node, List<Integer> list){
		if(node == null) return;
		list.add(node.val);
		serializeHelper(node.left, list);
		serializeHelper(node.right, list);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals("")) return null;
		String[] arr = data.split(",");
		System.out.println(arr.length);
		return deserializeHelper(arr, 0, arr.length-1);
	}

	public TreeNode deserializeHelper(String[] arr, int start, int end){
		int valStart = Integer.parseInt(arr[start]);
		TreeNode tn = new TreeNode(valStart);
		if(start == end)
			return new TreeNode(valStart);
		int index = start;
		for(int i = start+1; i<=end;i++){
			if(Integer.parseInt(arr[i])>valStart){
				index=i;
				break;
			}
		}
		if(index>start+1){
			tn.left = deserializeHelper(arr, start+1,index-1);
		}
		if(index>start){
			tn.right = deserializeHelper(arr, index, end);
		}
		return tn;
	}

	public static void main(String[] args) {

		SerializeAndDeserializeBST test = new SerializeAndDeserializeBST();
		String s =test.serialize(new TreeNode(3));
		System.out.println(s);
	}

}
