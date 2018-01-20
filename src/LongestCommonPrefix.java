import java.util.Arrays;


public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        else if(strs.length==1) return strs[0];
        else if(strs.length==2) return commongPrefixForTwo(strs[0], strs[1]);
        int mid = (strs.length-1)/2;
        String[] arr1 = Arrays.copyOfRange(strs, 0, mid);
        String[] arr2 = Arrays.copyOfRange(strs, mid, strs.length);
        return commongPrefixForTwo(longestCommonPrefix(arr1), longestCommonPrefix(arr2));
    }
	
	public String commongPrefixForTwo(String s1, String s2){
		StringBuilder sb = new StringBuilder();
		if(s1.length()==0 || s2.length() == 0 )
			return "";
		int len = Math.min(s1.length(), s2.length());
		for(int i=0;i<len;i++){
			if(s1.charAt(i)==s2.charAt(i))
				sb.append(s2.charAt(i));
			else
				return sb.toString();
		}
		return sb.toString();
	}
}
