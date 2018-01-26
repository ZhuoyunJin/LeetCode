package String;

public class DecodeString {
	/**
	 * s = "3[a]2[bc]", return "aaabcbc".
	 * s = "3[a2[c]]", return "accaccacc".
	 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 * Assume input is valid.
	 */
	public String decodeString(String s) {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<s.length();i++){
			char current = s.charAt(i);
			if(current>='0' && current<'9'){
				int number=0;
				int j = i;
				while(s.charAt(j)>='0' &&s.charAt(j)<='9'){
					number=number*10+(s.charAt(j)-'0');
					j++;
				}
				int indexBeginRepeat = j;
				int numberOfLeftPerenthesis = 0;
				while(true){
					if(s.charAt(j)=='[') numberOfLeftPerenthesis++;
					else if(s.charAt(j)==']') numberOfLeftPerenthesis--;
					if(numberOfLeftPerenthesis == 0) break;
					j++;
				}
				int indexEndepeat = j;
				String doneString = decodeString(s.substring(indexBeginRepeat+1, indexEndepeat));
				for(int k=0;k<number;k++){
					builder.append(doneString);
				}
				i=j;
			}
			else{
				builder.append(current);
			}
		}
		return builder.toString();
	}
	
	public static void main(String[] args) {
		DecodeString d = new DecodeString();
		System.out.print(d.decodeString("100[leetcode]"));
	}

}
