package Design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	int capacity;
	Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
	Map<Integer, LinkedHashSet<Integer>> list = new HashMap<Integer, LinkedHashSet<Integer>>();
	int min=-1;
	
	public LFUCache (int capacity) {
		this.capacity = capacity;
		list.put(1, new LinkedHashSet<Integer>());
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			int count = counter.get(key);
			counter.put(key, count+1);
			list.get(count).remove(key);
			if(!list.containsKey(count+1))
				list.put(count+1, new LinkedHashSet<Integer>());
			list.get(count+1).add(key);
			if(min == count && list.get(count).size()==0) min++;
			return cache.get(key);
		}else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if(capacity == 0) return;
		if(cache.containsKey(key)) {
			cache.put(key, value);
			get(key);
		}else if(cache.size() < capacity) {
			cache.put(key, value);
			counter.put(key, 1);
			min = 1;
			list.get(1).add(key);
		}else{
			int evictKey = list.get(min).iterator().next();
			list.get(min).remove(evictKey);
			cache.remove(evictKey);
			counter.remove(evictKey);
			cache.put(key, value);
			counter.put(key, 1);
			min = 1;
			list.get(1).add(key);
		}
		
	}
	public static void main(String[] args) {
		LFUCache cache = new LFUCache(0);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}

}
