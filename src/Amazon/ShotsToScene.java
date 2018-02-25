package Amazon;

import java.util.*;

public class ShotsToScene {

	public List<Integer> lengthOfScene(List<Character> shots){
		List<Integer> result = new ArrayList<Integer>();
		if(shots == null) {
			return result;
		}
		int i=0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character shot : shots) {
			map.put(shot, i);
			i++;
		}
		int slow=-1, fast = 0;
		int currentLastIndex=0;
		for(Character shot : shots) {
			int lastAppearnce = map.get(shot);
			if(currentLastIndex == 0) {
				currentLastIndex = lastAppearnce;
				fast++;
				continue;
			}
			if(lastAppearnce < currentLastIndex) {
				fast++;
				continue;
			}else {
				currentLastIndex = lastAppearnce;
			}
			if(fast == currentLastIndex) {
				int length = (fast - slow);
				slow = fast;
				result.add(length);
			}
			fast++;
		}
		return result;
	}

	public static void main(String[] args) {
		ShotsToScene test = new ShotsToScene();
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('b');
		list.add('a');
		list.add('c');
		list.add('a');
		list.add('d');
		list.add('e');
		list.add('f');
		list.add('e');
		list.add('g');
		list.add('d');
		list.add('e');
		list.add('h');
		list.add('i');
		list.add('j');
		list.add('h');
		list.add('k');
		list.add('l');
		list.add('i');
		list.add('j');

		System.out.println(test.lengthOfScene(list));
	}
}
