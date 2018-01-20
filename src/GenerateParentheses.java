import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<String>();
    	if(n==0) return result;
    	generator("",0,0,result, n);
    	return result;
    }
    
    public void generator(String str, int left, int right, List<String> result, int n){
    	if(left == right && left<n) {
    		str=str+"(";
    		generator(str, left+1, right, result, n);
    		return;
    	}else if(left == right && left ==n){
    		result.add(str);
    		return;
    	}else{
    		if(left<n)
    			generator(str+"(", left+1, right, result, n);
    		if(right<n)
    			generator(str+")", left, right+1, result, n);
    		return;
    	}
    }
}
