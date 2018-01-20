package Google;

import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null||s.length()==0) return true;
		int len = s.length();
		boolean[] arr = new boolean[len];
		for(int i=0;i<len;i++){
			if(i==0||arr[i-1]){
				for(String str:wordDict){
					if(i+str.length()>s.length()) continue;
					String subString = s.substring(i,i+str.length());
					if(str.equals(subString)){
						if(i+str.length()==len) return true;
						arr[i+str.length()-1] = true;
					}
				}
			}
		}
		return arr[len-1];
	}
}
