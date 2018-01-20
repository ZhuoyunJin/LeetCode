package LinkedList;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode ln = start;
        while(ln.next!=null){
        	if(ln.next.val == val){
        		ln.next=ln.next.next;
        	}else{
        		ln=ln.next;
        	}
        }
        return start.next;
    }
}
