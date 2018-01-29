package LinkedList;

import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
		ListNode a = ListNode.buildList(arr);
		ListNode.print(a);
		System.out.println("--------");
		//DeleteNodeInALinkedList d=new DeleteNodeInALinkedList();
		//d.xx(a);
		//a=a.next;
		//ListNode.print(a);
		//
		//d.test(a);
		//ListNode.print(a);
		//ConvertSortedListToBinarySearchTree r = new ConvertSortedListToBinarySearchTree();
		//System.out.println(r.sortedListToBST(a));
		
		ConvertSortedListToBinarySearchTree c = new ConvertSortedListToBinarySearchTree();
		c.sortedListToBST(a);
		
		List<Integer> list;
		Map<Integer, Integer> map;
	}

}
