package String;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> queue = new Stack<Character>();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('}', '{');
		map.put(']', '[');
		map.put(')', '(');
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(!map.containsKey(c))
				queue.add(c);
			else {
				if(queue.size()==0) return false;
				if(queue.peek()==map.get(c))
					queue.pop();
				else 
					return false;
			}
		}
		return queue.size()==0;
	}
}
