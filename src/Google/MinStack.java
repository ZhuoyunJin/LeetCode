package Google;

public class MinStack {
	class ListNode{
		int val;
		ListNode next = null;
		public ListNode(int x){
			this.val = x;
		}
	}
	ListNode minNode;
	ListNode stackNode;
	public void push(int x) {
		if(stackNode==null){
			stackNode = new ListNode(x);
			minNode = new ListNode(x);
		}else{
			ListNode newNode = new ListNode(x);
			newNode.next=stackNode;
			stackNode = newNode;

			ListNode newMinNode;
			if(minNode.val>x){
				newMinNode = new ListNode(x);
			}else {
				newMinNode = new ListNode(minNode.val);
			}
			newMinNode.next=minNode;
			minNode = newMinNode;
		}
	}

	public void pop() {
		minNode=minNode.next;
		stackNode=stackNode.next;
	}

	public int top() {
		return stackNode.val;
	}

	public int getMin() {
		return minNode.val;
	}
}
