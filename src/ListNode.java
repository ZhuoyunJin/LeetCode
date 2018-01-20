
public class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
	
	ListNode(int[] arr){
		if(arr.length ==1){
			this.val = arr[0];
		}else if(arr.length > 1){
			this.val = arr[0];
			ListNode temp = this;
			for(int i=1;i<arr.length;i++){
				temp.next = new ListNode(arr[i]);
				temp = temp.next;
			}
		}
	}

	void print(){
		System.out.print(val);
		if(next!=null) next.print();
	}
}
