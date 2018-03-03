package Design;

import java.util.*;

public class InsertDeleteGetRandom {
	Map<Integer, Integer> map;
	List<Integer> list;
	Random r = new Random();
	public InsertDeleteGetRandom() {
		this.map = new HashMap<Integer, Integer>();
		this.list = new ArrayList<Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val))
			return false;
		else {
			list.add(val);
			map.put(val, list.size()-1);
			return true;
		}
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		if(map.containsKey(val)) {
			int index = map.get(val);
			if(index == list.size()-1) {
				list.remove(index);
				map.remove(val);
			}else{
				int lastIndex = list.size()-1;
				int lastValue = list.get(lastIndex);
				list.add(index, lastValue);
				list.remove(lastIndex);
				map.put(lastValue, lastIndex);
				map.remove(val);
			}
			return true;
		}
		else{
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		int size= list.size();
		int randomNumber = r.nextInt(size);
		return list.get(randomNumber);
	}
	public static void main(String[] args) {
		InsertDeleteGetRandom randomSet = new InsertDeleteGetRandom();
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 2 is the only number in the set, getRandom always return 2.
		System.out.println(randomSet.getRandom());
	}

}
