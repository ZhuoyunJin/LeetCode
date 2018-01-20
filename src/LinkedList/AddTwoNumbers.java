package LinkedList;


public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		int increase = (l1.val+l2.val)/10;
		int sum = (l1.val+l2.val)%10;
		ListNode l3 = new ListNode(sum);
		ListNode result = l3;
		//ListNode tail;
		while(l1.next!=null && l2.next != null){
			l1=l1.next;
			l2=l2.next;
			sum = (l1.val+l2.val+increase)%10;
			increase =  (l1.val+l2.val+increase)/10;
			ListNode temp = new ListNode(sum);
			l3.next=temp;
			l3 = temp;
		}
		if(l1.next!=null){
			l3.next=l1.next;
			
		}
		else if(l2.next!=null){
			l3.next=l2.next;
		}
		if((l3.next!=null)&&(l3.next.val+increase>=10)){
			while(l3.next!=null){
				int temp = l3.next.val+increase;
				l3.next.val = temp%10;
				increase = temp/10;
				l3=l3.next;
			}
		}else if(l3.next!=null){
			l3.next.val += increase;
			increase = 0;
		}
		if(increase!=0){
			l3.next = new ListNode(increase);
		}
		return result;
	}
}
