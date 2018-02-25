package Microsoft;

public class Q1 {

	public String reverse(String str) {
		if(str == null || str.length()==0) {
			return str;
		}
		String[] arr = str.split(" ");
		StringBuilder builder = new StringBuilder();
		for(int i = arr.length-1;i >= 0;i--) {
			builder.append(arr[i]);
			if(i != 0) {
				builder.append(' ');
			}
		}
		return builder.toString();
	}
	
	public String reverse2(String str) {
		if(str == null || str.length() < 2) {
			return str;
		}
		char[] charArr = str.toCharArray();
		reverseString(charArr, 0, str.length()-1);
		//reverse the words
		int indexSlow = 0;
		for(int i=0; i< str.length()-1;i++) {
			if(charArr[i] == ' ') {
				reverseString(charArr, indexSlow, i-1);
				indexSlow = i+1;
			}
		}
		//reverse the last word
		reverseString(charArr, indexSlow, str.length()-1);
		return String.valueOf(charArr);
	}
	
	public void reverseString(char[] charArr, int start, int end) {
		//reverse the string
		for(int i=start; i< ((start+end)/2);i++) {
			char temp = charArr[i];
			charArr[i] = charArr[start+end-i];
			charArr[start+end-i] = temp;
		}
	}
	public static void main(String[] args) {
		Q1 q = new Q1();
		String rev = q.reverse2("The quick brown fox jumped");
		System.out.println(rev);
		
		char[] arr = null;
		for(char ch: arr) {
			System.out.println(ch);
		}
	}

}