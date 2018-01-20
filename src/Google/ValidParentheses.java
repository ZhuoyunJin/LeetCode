package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if(s==null) return false;
		if(s.length()==0) return true;
		Map<Character,Character> map=new HashMap<Character, Character>();
		map.put('{', '}');
		map.put('[', ']');
		map.put('(', ')');
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(map.containsKey(ch)){
				stack.push(ch);
			}
			else{
				if(stack.size()==0) return false;
				else{
					char popped = stack.pop();
					if(map.get(popped)!=ch)
						return false;
				}
			}
		}
		return (stack.size()==0);
	}
}
