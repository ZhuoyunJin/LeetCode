package String;

public class LongestPalindromicSubsequence {
	//abbaab
	public int longestPalindromeSubseqRecursion(String s) {
		if(s.length()<1) return 0;
		if(s.length()==1) return 1;
		if(s.length()==2) return s.charAt(0)==s.charAt(1)?2:1;
		if(s.charAt(0) == s.charAt(s.length()-1))
			return longestPalindromeSubseq(s.substring(1,s.length()-1))+2;
		else{
			return Math.max(longestPalindromeSubseq(s.substring(0, s.length()-1)),
					longestPalindromeSubseq(s.substring(1,s.length())));
		}
	}
	
	public int longestPalindromeSubseq(String s) {
		int len = s.length();
		int[][] arr = new int[len][len];
		for(int i=len-1;i>=0;i--){
			for(int j=i;j<len;j++){
				if(i==j) 
					arr[i][j] =  1;
				else if(s.charAt(i)==s.charAt(j))
					arr[i][j] = arr[i+1][j-1] + 2;
				else{
					arr[i][j] = Math.max(arr[i][j-1], arr[i+1][j]);
				}
			}
		}
		return arr[0][len-1];
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubsequence l = new LongestPalindromicSubsequence();
		System.out.println(l.longestPalindromeSubseq("bbbab"));
	}

}
