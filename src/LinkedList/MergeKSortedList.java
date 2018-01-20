package LinkedList;

import java.util.List;


public class MergeKSortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
    	int len = lists.size();
    	if(len==0) return null;
    	else if(len==1) return lists.get(0);
    	else if(len==2) return merge2Lists(lists.get(0), lists.get(1));
    	else{
    		ListNode n1=mergeKLists(lists.subList(0, (len-1)/2));
    		ListNode n2=mergeKLists(lists.subList((len-1)/2, len));
			return merge2Lists(n1,n2);
    
    	}
    }
    
    public ListNode merge2Lists(ListNode n1,ListNode n2){
    	if(n1==null) return n2;
    	if(n2==null) return n1;
    	ListNode res = new ListNode(0);
    	ListNode temp = res;
    	while(n1!=null && n2!=null){
    		if(n1.val<n2.val){
    			temp.next=n1;
    			temp=n1;
    			n1=n1.next;
    		}else{
    			temp.next = n2;
    			temp=n2;
    			n2=n2.next;
    		}
    	}
    	if(n1!=null) temp.next = n1;
    	if(n2!=null) temp.next = n2;
    	return res.next;
    }
}
