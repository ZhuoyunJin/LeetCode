package Design;

import java.util.*;

public class InsertDeleteGetRandomDuplicatesAllowed {
	Map<Integer, Set<Integer>> map;
	List<Integer> list;
	Random r;
	public InsertDeleteGetRandomDuplicatesAllowed() {
		map = new HashMap<Integer, Set<Integer>>();
		list = new ArrayList<Integer>();
		r= new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
        	list.add(val);
        	map.get(val).add(list.size()-1);
        	return false;
        }else {
        	list.add(val);
        	Set<Integer> set = new HashSet<Integer>();
        	set.add(list.size()-1);
        	map.put(val, set);
        	return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val))
        {
        	Set<Integer> locations = map.get(val);
        	
        	//remove val in list
        	int lastIndex =list.size()-1;
        	int lastValue = list.get(lastIndex);
        	int index =lastIndex;
        	if(lastValue != val) {
        		index = locations.iterator().next();
        		list.set(index, lastValue);
        		map.get(lastValue).remove(lastIndex);
            	map.get(lastValue).add(index);
        	}
        	list.remove(lastIndex);
        	
        	//update map
        	map.get(val).remove(index);
        	if(map.get(val).size() == 0)
        		map.remove(val);
        	return true;
        }else {
        	return false;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int index = r.nextInt(list.size());
        return list.get(index);
    }
	public static void main(String[] args) {
		// Init an empty collection.
		InsertDeleteGetRandomDuplicatesAllowed collection = new InsertDeleteGetRandomDuplicatesAllowed();

		collection.insert(4);
		collection.insert(3);
		collection.insert(4);
		collection.insert(2);
		collection.insert(4);
		
		collection.remove(4);
		collection.remove(3);
		collection.remove(4);
		collection.remove(4);
		// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
		System.out.println(collection.getRandom());
		System.out.println(collection.getRandom());
		System.out.println(collection.getRandom());
		System.out.println(collection.getRandom());
		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		collection.remove(1);

		// getRandom should return 1 and 2 both equally likely.
		System.out.println(collection.getRandom());
		System.out.println(collection.getRandom());
		System.out.println(collection.getRandom());
	}

}
