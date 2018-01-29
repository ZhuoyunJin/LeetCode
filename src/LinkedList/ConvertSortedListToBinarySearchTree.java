package LinkedList;
import Tree.TreeNode;
public class ConvertSortedListToBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) return null;
		ListNode temp = head;
		int count = 0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		if(count==1) return new TreeNode(head.val);
		if(count==2) {
			TreeNode returnNode = new TreeNode(head.next.val);
			returnNode.left = new TreeNode(head.val);
			return returnNode;
		}
		int mid = count/2;
		ListNode MidNode=head;
		ListNode PrevNode=head;
		for(int i=0;i<mid;i++){
			PrevNode = MidNode;
			MidNode = MidNode.next;
		}
		PrevNode.next=null;
		TreeNode returnNode = new TreeNode(MidNode.val);
		returnNode.left = sortedListToBST(head);
		returnNode.right = sortedListToBST(MidNode.next);
		return returnNode;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
