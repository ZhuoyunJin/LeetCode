package String;

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if(s1==null||s2==null) return false;
		int len = s1.length();
		if(len==1) return s1.equals(s2);
		boolean isScrambled = false;
		for(int i=1;i<=len;i++){
			String sub11 = s1.substring(0,i);
			String sub12 = s1.substring(i,len);
			String sub21 = s2.substring(0,len-i);
			String sub22 = s2.substring(len-i,len);	
			if(isScramble(sub11, sub22) && isScramble(sub12, sub21)){
				isScrambled = true;
				break;
			}
		}
		return isScrambled;
	}
	
	public static void main(String[] args) {
		ScrambleString t = new ScrambleString();
		System.out.println(t.isScramble("abb", "bab"));;
	}

}
