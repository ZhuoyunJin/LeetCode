package LinkedList;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode prehead = new ListNode(0);
		prehead.next=head;
		int i;
		ListNode copyNode=prehead;
		for(i=1;i<m;i++){
			prehead=prehead.next;
			
		}
		ListNode newNode=prehead.next;
		ListNode nextNode=prehead.next.next;
		while(i<n){
			ListNode temp=nextNode.next;
			nextNode.next=newNode;
			newNode=nextNode;
			nextNode=temp;
			i++;
		}
		prehead.next.next=nextNode;
		prehead.next=newNode;
		return copyNode.next;
	}
}
