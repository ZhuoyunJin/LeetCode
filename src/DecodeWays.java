
public class DecodeWays {
	/**
	 * Given an encoded message containing digits, determine the total number of ways to decode it.
	 * For example,
	 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	 * The number of ways decoding "12" is 2.
	 */
	public int helper(String s) {
		if(s.length() == 0) return 1;
		if(s.length()==1)  
			return (s.charAt(0)=='0')?0:1;
		int result = 0;
		char last = s.charAt(s.length()-1);
		char lastButOne = s.charAt(s.length()-2);
		int sum = (lastButOne-'0')*10+(last-'0');

		if(last!='0') result += helper(s.substring(0,s.length()-1));

		if(sum<=26 && lastButOne!='0'){
			result+=helper(s.substring(0,s.length()-2));
		}
		return result;
	}

	public int numDecodings(String s) {
		if(s==null || s.length() == 0) return 0;
		return helper(s);
	}
	
	public int numDecodings2(String s) {
		if(s==null || s.length() == 0) return 0;
		int[] arr = new int[s.length()];
		for(int i=0;i<s.length();i++){
			if(i==0){
				arr[i] = s.charAt(i)=='0'?0:1;
			}else{
				int sum= (s.charAt(i-1)-'0')*10+(s.charAt(i)-'0');
				if(sum<=26 && sum >= 10) arr[i]+=(i>1)?arr[i-2]:1;
				if(s.charAt(i)!='0') arr[i]+=arr[i-1];
			}
		}
		return arr[s.length()-1];
	}
	public static void main(String[] args) {
		DecodeWays decodeWays = new DecodeWays();
		System.out.println(decodeWays.numDecodings2("27"));
	}

}
