package LinkedList;

public class ReverseNodeInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {

		ListNode top=new ListNode(0);
		top.next=head;
		ListNode h=top;
		while(true){
			h=reverseList(h,k);
			if(h==null) return top.next;
		}
	}

	public ListNode reverseList(ListNode head, int k){
		ListNode headCopy = head;
		for(int i=0;i<k;i++){
			if(head.next==null) return null;
			else head=head.next;
		}
		ListNode tail = head.next;
		ListNode current = headCopy.next;
		ListNode tailCopy=current;
		ListNode next = current.next;
		for(int i=0;i<k;i++){
			System.out.println(i);
			current.next=tail;
			tail=current;
			current=next;
			if(i<k-1)
				next=next.next;
		}
		headCopy.next=tail;
		return tailCopy;
	}
}
