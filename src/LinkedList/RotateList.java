package LinkedList;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		int len=getLength(head);
		if(len==0) return head;
		n=n%len;
		if(n==0) return head;
		ListNode front = head;
		ListNode back=head;
		while(n>0){
			front=front.next;
			n--;
		}
		while(front.next!=null){
			front=front.next;
			back=back.next;
		}
		ListNode newhead=back.next;
		back.next=null;
		front.next=head;
		return newhead;
	}
	public int getLength(ListNode head){
		int len=0;
		while(head!=null){
			head=head.next;
			len++;
		}
		return len;
	}
}
