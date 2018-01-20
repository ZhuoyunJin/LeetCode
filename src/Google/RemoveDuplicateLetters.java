package Google;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * "bcabc" -> "abc"
 * "cbacdcbc" -> "acdb"
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		boolean[] map = new boolean[26];
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			map[ch-'a']=true;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<map.length;i++){
			if(map[i])
				sb.append((char)('a'+i));
		}
		return sb.toString();
	}
}
