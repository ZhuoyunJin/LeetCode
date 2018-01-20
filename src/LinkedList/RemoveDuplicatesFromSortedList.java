package LinkedList;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode chead = head, result=head;;
		int value=head.val;
		chead=chead.next;
		while(chead!=null){
			if(chead.val!=value){
				value=chead.val;
				result.next=chead;
				result=result.next;
			}
			chead=chead.next;
		}
		result.next=null;
		return head;
	}
}
