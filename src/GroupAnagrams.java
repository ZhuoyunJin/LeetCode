import java.util.*;
public class GroupAnagrams {
	/**
	 * Given an array of strings, group anagrams together.
	 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
	 * Return:
	 * [
	 * 	["ate", "eat","tea"],
	 * 	["nat","tan"],
	 * 	["bat"]
	 * ]
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		//hashmap: key -> anagram sorted. value -> list of strs
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0;i<strs.length;i++){
			String string = strs[i];
			//sort the string.
			String sortedString = sort(string);
			if(map.containsKey(sortedString))
				map.get(sortedString).add(string);
			else{
				List<String> list = new ArrayList<String>();
				list.add(string);
				map.put(sortedString, list);
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		for(String key : map.keySet()){
			result.add(map.get(key));
		}
		return result;
	}
	
	public String sort(String str){
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return String.valueOf(charArray);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
