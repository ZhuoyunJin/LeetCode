import java.util.Stack;


public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max=0;
		if(s.length()<=1) return max;
		Stack<Integer> stack=new Stack<Integer>();
		int index=-1;
		for(int i=0;i<s.length();i++){
			char ch=s.charAt(i);
			if(ch=='('){
				stack.push(i);
			}else{
				if(stack.isEmpty()){
					index=i;
				}else{
					stack.pop();
					if(stack.isEmpty())
						max=Math.max(max,i-index);
					else
						max=Math.max(max,i-stack.peek());
				}
			}
		}
		return max;
	}
}
