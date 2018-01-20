package LinkedList;

public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node) {
		if(node==null) return;
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	public void test(ListNode a){
		a.val=0;
	}
	public void xx(ListNode a){
		a=a.next;
//		a.val=0;
	}
}
