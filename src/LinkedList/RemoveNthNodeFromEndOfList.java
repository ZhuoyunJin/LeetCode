package LinkedList;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode res = head;
		ListNode end = head;
        for(int i=0;i<n;i++){
        	end=end.next;
        }
        if(end==null) return head.next;
        while(end.next!=null){
        	end=end.next;
        	head=head.next;
        }
        head.next = head.next.next;
        return res;
    }
}
