package String;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
	public int findLHS(int[] nums) {
		if(nums == null) return 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int longest = 0;
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		for(int i: map.keySet()) {
			int length = 0;
			if(map.containsKey(i-1)) {
				int minusOne = map.get(i-1);
				int current = map.get(i);
				length =current+minusOne;
			}
			if(length>longest) longest = length;
		}
		return longest;
	}
	
	public static void main(String[] args) {
		LongestHarmoniousSubsequence l = new LongestHarmoniousSubsequence();
		System.out.println(l.findLHS(new int[] {-1,0,-1,0,-1,0,-1}));
	}

}
