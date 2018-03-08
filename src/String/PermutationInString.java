package String;

import java.util.HashMap;
import java.util.Map;


public class PermutationInString {
	/**
	 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
	 * In other words, one of the first string's permutations is the substring of the second string.
	 */
	public boolean checkInclusion(String s1, String s2) {
		if(s1.length()>s2.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s1.length();i++) {
			char current = s1.charAt(i);
			map.put(current, map.getOrDefault(current, 0)+1);
		}
		int counter = map.size();

		for(int i=0;i<s2.length();i++) {
			char current = s2.charAt(i);
			if(map.containsKey(current)) {
				map.put(current, map.get(current)-1);
				if(map.get(current) == 0) {
					counter--;
				}
			}
			if(i>=s1.length()) {
				char begin = s2.charAt(i-s1.length());
				if(map.containsKey(begin)) {
					if(map.get(begin) == 0) counter++;
					map.put(begin, map.get(begin)+1);
				}
			}
			if(counter == 0) return true;
		}
		return false;
	}

	public boolean checkInclusion2(String s1, String s2) {
		if(s1.length()>s2.length()) return false;
		int[] arr = new int[26];
		int counter = 0;
		for(int i=0;i<s1.length();i++) {
			int index = s1.charAt(i)-'a';
			if(arr[index]==0) {
				counter++;
			}
			arr[index]++;
		}

		for(int i=0;i<s2.length();i++) {
			char current = s2.charAt(i);
			arr[current-'a']--;
			if(arr[current-'a'] == 0) counter--;
			if(arr[current-'a'] == -1) counter++;
			
			if(i>=s1.length()) {
				char begin = s2.charAt(i-s1.length());
				arr[begin-'a']++;
				if(arr[begin-'a'] == 0) counter--;
				if(arr[begin-'a'] == 1) counter++;
			}
			if(counter == 0) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		PermutationInString test = new PermutationInString();
		System.out.println(test.checkInclusion2("hello","fjeiollehdfs"));
	}

}
