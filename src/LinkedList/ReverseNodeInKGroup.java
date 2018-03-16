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
			//System.out.println(i);
			current.next=tail;
			tail=current;
			current=next;
			if(i<k-1)
				next=next.next;
		}
		headCopy.next=tail;
		return tailCopy;
	}

	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode start= new ListNode(0);
		start.next = head;
		reverse(start, k);
		return start.next;
	}

	public void reverse(ListNode start, int k) {
		if(start.next==null|| start.next.next ==null) return;
		ListNode tail = start;
		for(int i=0;i<k;i++) {
			if(tail.next == null) return;
			tail = tail.next;
		}
		ListNode endNode = tail.next;
		ListNode head = start.next;
		ListNode headCopy = head;
		start.next = tail;
		ListNode next = head.next;
		for(int i=0;i<k-1;i++) {
			ListNode nextNext = next.next;
			next.next = head;
			head = next;
			next = nextNext;
			//System.out.println(head.val);
		}
		
		headCopy.next = endNode;
		reverse(headCopy, k);
	}

	public static void main(String[] args) {
		ReverseNodeInKGroup test = new ReverseNodeInKGroup();
		ListNode head = ListNode.buildList(new int[] {1,2});
		ListNode head2 =test.reverseKGroup2(head, 5);
		ListNode.print(head2);
	}
}
