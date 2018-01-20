package LinkedList;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode ca = headA, cb=headB;
		int ma=0,nb=0;
		while(ca!=null){
			ca=ca.next;
			ma++;
		}
		while(cb!=null){
			cb=cb.next;
			nb++;
		}
		ca = headA;
		cb=headB;
		int diff=Math.abs(ma-nb);
		if(ma>nb){
			for(int i=0;i<diff;i++){
				ca=ca.next;
			}
		}else{
			for(int i=0;i<diff;i++){
				cb=cb.next;
			}
		}
		while(ca!=cb){
			ca=ca.next;
			cb=cb.next;
		}
		return ca;
	}
}
