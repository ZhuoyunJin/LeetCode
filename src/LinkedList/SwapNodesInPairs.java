package LinkedList;

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null ||head.next==null) return head;
		ListNode first = new ListNode(0);
		first.next = head;
		ListNode firstCopy = first;
		while(first.next!=null && first.next.next!=null){
			ListNode copy = first.next;
			ListNode after = first.next.next.next;
			first.next=first.next.next;
			copy.next.next = copy;
			copy.next=after;
			first=first.next.next;
		}
		return firstCopy.next;
	}
}
