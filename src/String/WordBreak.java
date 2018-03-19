package String;
import java.util.*;
public class WordBreak {
	public boolean wordBreak2(String s, Set<String> wordDict) {
		if (s == null && wordDict == null)
			return true;
		if (s == null || wordDict == null)
			return false;
		//dp[i] represents if s.substring(0, i) is wordbreakable.
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if(s==null || wordDict==null) return false;
		//Build set
		Set<String> set = new HashSet<>();
		for(String str: wordDict) {
			set.add(str);
		}
		boolean[] arr = new boolean[s.length()+1];
		arr[0] = true;
		for(int i=1;i<=s.length();i++) {
			for(int j=1;j<=i;j++) {
				if(arr[j-1] && set.contains(s.substring(j-1, i))) {
					arr[i] = true;
					break;
				}
			}
		}
		return arr[s.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak test = new WordBreak();
		List<String> set = new ArrayList<>();
		set.add("cat");
		set.add("catty");
		set.add("big");
		System.out.println(test.wordBreak("cattybig", set));
	}

}
