import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		return longest(s);
	}

	public int longest(String s){
		if(s.length()==0) return 0;
		int index;
		int max=0;
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			if(map.containsKey(s.charAt(i))){
				index = map.get(s.charAt(i));
				int nextMax=longest(s.substring(index+1));
				return max>nextMax?max:nextMax;
			}else{
				map.put(s.charAt(i), i);
				max++;
			}
		}
		return max;
	}

	public int lengthOfLongestSubstring2(String s) {
		int max = 0;
		int count = 0;
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0;i<s.length();i++){
			if(q.contains(s.charAt(i))){
				max = count>max?count:max;
				do{
					count--;
				}
				while(q.poll()!=s.charAt(i));

			}
			q.add(s.charAt(i));
			count++;
		}
		max = count>max?count:max;
		return max;
	}
}
