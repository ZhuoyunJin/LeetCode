package Amazon;

import java.util.HashSet;
import java.util.Set;

public class RemoveAlternateDuplicate {
	public String removeAlternateDuplicate(String str) {
		char[] charArr = str.toCharArray();
		Set<Character> set = new HashSet<>();
		int left=0;
		for(int i=0;i<str.length();i++) {
			char current = charArr[i];
			if(set.contains(current)) {
				set.remove(current);
				
			}else {
				set.add(current);
				if(i>left) {
					charArr[left] = charArr[i];
				}
				left++;
			}
		}
		
		return new String(charArr, 0, left);
		
	}
	public static void main(String[] args) {
		RemoveAlternateDuplicate test = new RemoveAlternateDuplicate();
		System.out.println(test.removeAlternateDuplicate("you got beautiful eyes"));
	}

}
