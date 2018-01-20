package LinkedList;

public class ReverseLinkedList {
	public ListNode reverseList2(ListNode head) {
		if(head==null) return null;
		ListNode startListNode = new ListNode(0);
		recursive(startListNode, head);
		return startListNode.next;
	}

	private ListNode recursive(ListNode start, ListNode current){
		if(current.next!=null){
			ListNode retVal = recursive(start, current.next);
			retVal.next = current;
		}
		else{
			start.next = current;
		}
		current.next = null;
		return current;
	}
	
	public ListNode reverseList(ListNode head) {
		if(head==null) return null;
		ListNode start = new ListNode(0);
		
		return start.next;
	}

}
