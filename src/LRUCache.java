import java.util.HashMap;
import java.util.Map;

class DoubleLinkedListNode{
	int val;
	int key;
	DoubleLinkedListNode prev=null;
	DoubleLinkedListNode next=null;

	public DoubleLinkedListNode(DoubleLinkedListNode prev, DoubleLinkedListNode next,int val, int key) {
		this.prev=prev;
		this.next=next;
		this.val=val;
		this.key=key;
	}

	public DoubleLinkedListNode(int val, int key) {
		this.val=val;
		this.key=key;
	}
}

public class LRUCache {
	int capacity;
	Map<Integer,DoubleLinkedListNode> map;
	DoubleLinkedListNode last;
	DoubleLinkedListNode first;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map=new HashMap<Integer, DoubleLinkedListNode>();
	}

	public int get(int key) {
		if(!map.containsKey(key)) return -1;
		else {
			DoubleLinkedListNode node = map.get(key);
			if(last==node) return node.val;
			if(first!=node)
				node.prev.next=node.next;
			else {
				first=node.next;
			}
			node.next.prev=node.prev;
			last.next=node;
			node.prev=last;
			node.next=null;
			last=node;
			return node.val;
		}
	}

	public void set(int key, int value) {
		if(!map.containsKey(key)){
			DoubleLinkedListNode node=new DoubleLinkedListNode(value,key);
			if(map.size()>=capacity){
				map.remove(first.key);
				if(capacity==1){
					first=node;
					last=node;
				}else{
					first=first.next;
					first.prev=null;
					last.next=node;
					node.prev=last;
					last=node;
				}
				
			}else{
				if(map.size()==0){
					first=node;
					last=node;
				}
				else{
					last.next=node;
					node.prev=last;
					last=node;
				}
			}
			map.put(key, node);
		}else{
			DoubleLinkedListNode node = map.get(key);
			node.val=value;
			if(last==node) {
				return;
			}
			if(first!=node)
				node.prev.next=node.next;
			else {
				first=node.next;
			}
			node.next.prev=node.prev;
			last.next=node;
			node.prev=last;
			node.next=null;
			last=node;	
		}
	}
}
