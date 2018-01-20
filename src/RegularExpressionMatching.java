
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if(s.length()==0&&p.length()==0) return true;
		else if(s.length()==0){
			if(p.length()==1||p.charAt(1)!='*') return false;
			else return isMatch(s, p.substring(2));
		}else if(p.length()==0){
			return false;
		}else if(p.length()==1 || p.charAt(1)!='*'){
			if(p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))
				return isMatch(s.substring(1), p.substring(1));
			else 
				return false;
		}
		else{
			if(p.charAt(0)=='.'){
				for(int i=0;i<=s.length();i++){
					if(isMatch(s.substring(i), p.substring(2))) return true;
					
				}
				return false;
			}else{
				for(int i=0;i<=s.length();i++){
					if(isMatch(s.substring(i), p.substring(2))) return true;
					if(i<s.length() && s.charAt(i)!=p.charAt(0)) break;
				}
				return false;
			}
		}
	}
}
