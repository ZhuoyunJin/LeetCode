package LinkedList;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		return helper(lists, 0, lists.length-1);
	}

	public ListNode helper(ListNode[] lists, int start, int end) {
		if(start==end) return lists[start];
		//if(start== (end-1)) return sort2List(lists[start], lists[end]);
		return sort2List(helper(lists, start, (end+start)/2), 
				helper(lists, ((end+start)/2)+1, end));
	}

	public ListNode sort2List(ListNode n1, ListNode n2) {
		if(n1==null) return n2;
		if(n2==null) return n1;
		ListNode result = new ListNode(0);
		ListNode resultCopy = result;
		while(n1!=null && n2!=null) {
			if(n1.val<n2.val) {
				result.next = new ListNode(n1.val);
				n1 = n1.next;
			}else {
				result.next = new ListNode(n2.val);
				n2 = n2.next;
			}
			result = result.next;
		}
		result.next = n1==null?n2:n1;
		return resultCopy.next;
	}
	public static void main(String[] args) {
		//[[-10,-9,-9,-3,-1,-1,0],[-5],[4],[-8],[],[-9,-6,-5,-4,-2,2,3],[-3,-3,-2,-1,0]]
		ListNode node1 = ListNode.buildList(new int[] {-10,-9,-9,-3,-1,-1,0});
		ListNode node2 = ListNode.buildList(new int[] {-5});
		ListNode node3 = ListNode.buildList(new int[] {4});
		ListNode node4 = ListNode.buildList(new int[] {-8});
		ListNode node5 = ListNode.buildList(new int[] {-9,-6,-5,-4,-2,2,3});
		ListNode node6 = ListNode.buildList(new int[] {-3,-3,-2,-1,0});
		
		MergeKSortedLists test = new MergeKSortedLists();
		//ListNode.print(test.sort2List(node1,node3));
		ListNode node = test.mergeKLists(new ListNode[] {node1, node2,node3, node4,node5, node6});
		ListNode.print(node);
	}

}
