package LinkedList;

public class Test {

	public static void main(String[] args) {
		int[] arr=new int[]{1,2,3,4};
		ListNode a = ListNode.buildList(arr);
		ListNode.print(a);
		System.out.println("--------");
		DeleteNodeInALinkedList d=new DeleteNodeInALinkedList();
		d.xx(a);
		//a=a.next;
		ListNode.print(a);
		//
		//d.test(a);
		//ListNode.print(a);
		//ConvertSortedListToBinarySearchTree r = new ConvertSortedListToBinarySearchTree();
		//System.out.println(r.sortedListToBST(a));
	}

}
