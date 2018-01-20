
public class StringToInteger {
	public int atoi(String str) {
		if(str.length()==0) return 0;
		str = str.trim();
		int isNegtive = 1;
		int i=0;
		int result=0;
		if(str.charAt(0)=='-'){
			isNegtive = -1;
			i=1;
		}else if(str.charAt(0)=='+'){
			i=1;
		}
		for(;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch<='9' && ch>='0'){
				if(Integer.MAX_VALUE/10 < result)
					return isNegtive==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
				else if(Integer.MAX_VALUE/10 == result && (ch-'0')>=8)
					return isNegtive==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
				result = result*10 + (ch-'0');
			}else{
				break;
			}
		}
		return isNegtive*result;
	}
}
