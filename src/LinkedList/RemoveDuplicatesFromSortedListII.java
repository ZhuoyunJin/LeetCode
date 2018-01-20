package LinkedList;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode result=new ListNode(0), chead=head;
		ListNode cr=result;
		while(chead!=null){
			if(chead.next!=null && chead.val==chead.next.val){
				int value=chead.val;
				while(chead!=null&&chead.val==value){
					chead=chead.next;
				}
				continue;
			}else{
				result.next=chead;
				result=result.next;
			}
			chead=chead.next;
		}
		result.next=null;
		return cr.next;
	}
}
