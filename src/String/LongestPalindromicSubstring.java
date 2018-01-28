package String;

public class LongestPalindromicSubstring {
	public String longestPalindromeN(String s) {
		int len=s.length();
		if(len==0) return "";
	    boolean[][] table = new boolean[len][len];
	    int max=0,left=0,right=0;
	    for(int i=0;i<len;i++){
	    	for(int j=0;j+i<len;j++){
	    		int x=j, y=i+j;
	    		if(i==0) table[x][y]=true;
	    		else if(i==1) {
	    			table[x][y]=(s.charAt(x)==s.charAt(y));
	    			if(table[x][y]){
	    				max=2;
	    				left=x;
	    				right=y;
	    			}
	    		}
	    		else{
	    			table[x][y]=(s.charAt(x)==s.charAt(y)&& table[x+1][y-1]);
	    			if(table[x][y] && (y-x+1)>max){
	    				max=y-x+1;
	    				left=x;
	    				right=y;
	    			}
	    		}
	    	}
	    }
	    return s.substring(left,right+1);
	}
	
	public String reverseString(String s){
		char[] arr = s.toCharArray();
		for(int i=0;i<s.length()/2;i++){
			char temp = arr[i];
			arr[i] = arr[s.length()-i-1];
			arr[s.length()-i-1] = temp;
		}
		return  new String(arr);
	}
	
	public String LongestCommonSubstring(String s1, String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		int max = 0;
		int index = 0;
		int[][] table = new int[len1][len2];
		table[0][0] = s1.charAt(0)==s2.charAt(0)?1:0;
		for(int i=0;i<len1;i++){
			table[i][0] = s1.charAt(i)==s2.charAt(0)?1:0;
		}
		for(int j=1;j<len2;j++){
			table[0][j] = s2.charAt(j)==s1.charAt(0)?1:0;
		}
		for(int i=1;i<len1;i++){
			for(int j=1;j<len2;j++){
				table[i][j]=s1.charAt(i)==s2.charAt(j)?table[i-1][j-1]+1:0;
			}
		}
		for(int i=0;i<len1;i++){
			for(int j=0;j<len2;j++){
				if(table[i][j]>max){
				max=table[i][j];
				index = i;
				}
			}
		}
		String res = s1.substring(index-max+1,index+1);
		return res;
	}
	public String longestPalindrome(String s) {
		String rs = reverseString(s);
		return LongestCommonSubstring(s, rs);
	}
	
	public String longestPalindrome2(String s) {
		int len = s.length();
		int max = 0;
		String res = "";
		for(int i=0;i<len;i++){
			for(int j=len;j>=i;j--){
				//System.out.println(i+" "+j);
				String sub = s.substring(i, j);
				if(isPalindrome(sub)){
					if(sub.length()>max){
						max = sub.length();
						res = sub;
					}
				}
			}
		}
        return res;
    }
	public boolean isPalindrome(String s){
		for(int i=0, j=s.length()-1;i<j;i++,j--){
			if(s.charAt(i)!=s.charAt(j)) return false;
		}
		return true;
	}
    
    public String longestPalindrome3(String s) {

        for (int l = s.length(); l > 0; l--) {
            for (int i = s.length() - l; i > -1; i--) {
                if (isPalindorme(s, i, i + l - 1))
                    return s.substring(i, i + l);
            }
        }
        return null;
    }

    public boolean isPalindorme(String s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
