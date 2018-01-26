
public class DecodeWays {
	/**
	 * Given an encoded message containing digits, determine the total number of ways to decode it.
	 * For example,
	 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	 * The number of ways decoding "12" is 2.
	 */
	public int numDecodings(String s) {
		if(s==null || s.length() == 0) return 0;
		if(s.length()==1)  
			return (s.charAt(0)=='0')?0:1;
		char last = s.charAt(s.length()-1);
		char lastButOne = s.charAt(s.length()-2);
		
		int sum = (lastButOne-'0')*10+(last-'0');

		int waysOfLastTwoChars = (sum>26 || last=='0') ? 0:1;
		return numDecodings(s.substring(0,s.length()-1))
				+numDecodings(s.substring(0,s.length()-2))
				+waysOfLastTwoChars;
	}
	public static void main(String[] args) {
		DecodeWays decodeWays = new DecodeWays();
		System.out.println(decodeWays.numDecodings("10"));
	}

}
