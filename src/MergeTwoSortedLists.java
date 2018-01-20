
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null&&l2==null) return null;
        ListNode mergedListNode=new ListNode(0);
        ListNode result=mergedListNode;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		mergedListNode.next=l1;
        		l1=l1.next;
        		mergedListNode=mergedListNode.next;
        	}else{
        		mergedListNode.next=l2;
        		l2=l2.next;
        		mergedListNode=mergedListNode.next;
        	}
        }
        if(l1==null) mergedListNode.next=l2;
        else mergedListNode.next=l1;
        return result.next;
    }
}
