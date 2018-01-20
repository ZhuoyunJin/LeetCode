package Google;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		int[] count = new int[256];
		for(int i=0;i<s.length();i++){
			count[s.charAt(i)]++;
		}
		int flag = 0;
		for(int i=0; i<count.length;i++){
			if(count[i]%2==0)
				continue;
			else{
				flag++;
				if(flag>1) return false;
			}
		}
		return true;
	}
	
	public boolean canPermutePalindrome2(String s){
		if(s==null || s.length()==0) return true;
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++){
			char ch= s.charAt(i);
			if(!set.add(ch))
				set.remove(ch);
		}
		return set.size()<=1;
	}
}
