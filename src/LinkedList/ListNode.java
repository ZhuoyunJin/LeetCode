package LinkedList;

public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	public static void print(ListNode node){
		while(node!=null){
			System.out.println(node.val);
			node=node.next;
		}
	}
	public static ListNode buildList(int[] arr){
		ListNode head=new ListNode(0);
		ListNode pointListNode = head;
		for(int i=0;i<arr.length;i++){
			ListNode newNode = new ListNode(arr[i]);
			pointListNode.next=newNode;
			pointListNode=pointListNode.next;
		}
		return head.next;
	}
}
