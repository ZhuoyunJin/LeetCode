package Tree;

public class ScrambleString {
	class StringTreeNode{
		String val;
		StringTreeNode left;
		StringTreeNode right;

		public StringTreeNode(String s){
			this.val = s;
			this.left = null;
			this.right= null;
		}
	}
	public boolean isScramble(String s1, String s2) {
		if(s1==null||s2==null) return false;
		if(s1.length()!=s2.length()) return false;
		StringTreeNode n1 = buildTree(s1);
		StringTreeNode n2 = buildTree(s2);
		return helper(n1,n2);
	}

	public Boolean helper(StringTreeNode n1, StringTreeNode n2){
		if(n1.left == null || n1.right==null) return false;
		if(n1.left.val.equals(n2.right.val) && n1.right.val.equals(n2.left.val))
			return true;
		return helper(n1.left, n2.left) || helper(n1.right, n2.right);
	}
	public StringTreeNode buildTree(String s){

		StringTreeNode node = new StringTreeNode(s);
		if(s.length()<=1) return node;
		node.left=buildTree(s.substring(0, s.length()/2));
		node.right=buildTree(s.substring(s.length()/2, s.length()));
		return node;
	}
	public static void main(String[] args) {
		ScrambleString t = new ScrambleString();
		System.out.println(t.isScramble("great", "eeeee"));;
	}

}
