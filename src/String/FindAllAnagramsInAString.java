package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Input: 
 * 	s: "cbaebabacd" p: "abc"
 * Output:
 * 	[0, 6]
 */
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || p == null) return result;
		if(s.length()<p.length()) return result;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int size=0;
		for(int i=0;i<p.length();i++){
			char current = p.charAt(i);
			int count = map.containsKey(current)? map.get(current)+1:1;
			map.put(current, count);
		}
		size = map.size();

		for(int i=0;i<p.length();i++){
			char current = s.charAt(i);
			Integer count = map.get(current);
			if(map.containsKey(current)){
				count--;
				map.put(current, count);
				if(count==0) size--;
			}
		}
		if(size == 0) result.add(0);
		int left=0, right = p.length();
		while(right<s.length()){
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if(leftChar != rightChar){
				if(map.containsKey(leftChar)){
					int count = map.get(leftChar);
					if(count==0) size++;
					map.put(leftChar, count+1);
				}
				if(map.containsKey(rightChar)){
					int count = map.get(rightChar);
					if(count==1) size--;
					map.put(rightChar, count-1);
				}
			}
			if(size==0) result.add(left+1);
			left++;
			right++;
		}

		return result;
	}

	public List<Integer> findAnagrams2(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || p == null) return result;
		if(s.length()<p.length()) return result;
		int[] arr = new int[26];
		int count=0;
		for(int i=0;i<p.length();i++){
			char current = p.charAt(i);
			arr[current-'a']++;
			count++;
		}
		
		for(int i=0;i<p.length();i++){
			char current = s.charAt(i);
			if(arr[current-'a']>0) count--;
			arr[current-'a']--;
		}
		if(count == 0) result.add(0);
		
		int left=0, right = p.length();
		while(right<s.length()){
			char leftChar = s.charAt(left);
			char rightChar = s.charAt(right);
			if(leftChar != rightChar){
				if(arr[leftChar-'a'] >= 0) count++;
				arr[leftChar-'a']++;
				if(arr[rightChar-'a'] > 0) count--;
				arr[rightChar-'a']--;
			}
			if(count==0) result.add(left+1);
			left++;
			right++;
		}
		return result;
	} 

	public static void main(String[] args) {
		FindAllAnagramsInAString f = new FindAllAnagramsInAString();
		System.out.println(f.findAnagrams2("aaaa", "aa"));
	}

}
