
public class ImplementstrStr {
	public String strStr(String haystack, String needle) {
		if(needle.length()==0) return haystack;
		else if(haystack.length()==0) return null;

        for(int i=0;i<=haystack.length()-needle.length();i++){
        	if(haystack.substring(i, i+needle.length()).equals(needle)) return haystack.substring(i);
        }
        return null;
    }
}
