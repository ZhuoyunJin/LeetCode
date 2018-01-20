package LinkedList;

public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode left=new ListNode(0),right=new ListNode(0);
		ListNode cleft=left,cright=right;
		while(head!=null){
			if(head.val<x){
				left.next=head;
				left=left.next;

			}else{
				right.next=head;
				right=right.next;
			}
			head=head.next;
		}
		left.next=null;
		right.next=null;
		if(cleft.next==null) return cright.next;
		else if(cright.next==null) return cleft.next;
		else{
			left.next=cright.next;
			return cleft.next;
		}
	}
}
