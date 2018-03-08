package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode headCopy = head;
		Map<Integer, RandomListNode> map = new HashMap<>();
		RandomListNode cHead = new RandomListNode(head.label);
		map.put(cHead.label, cHead);
		RandomListNode retNode = cHead;
		while(headCopy.next!=null) {
			headCopy = headCopy.next;
			cHead.next=new RandomListNode(headCopy.label);
			cHead = cHead.next;
			map.put(cHead.label, cHead);
		}

		headCopy = head;
		cHead = retNode;
		if(headCopy.random!=null)
			cHead.random = map.get(headCopy.random.label);
		while(headCopy.next!=null) {
			headCopy = headCopy.next;
			cHead = cHead.next;
			if(headCopy.random!=null)
				cHead.random = map.get(headCopy.random.label);
		}
		return retNode;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
