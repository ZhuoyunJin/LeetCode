import java.util.ArrayList;
import java.util.List;


public class NQueensII {
	public int totalNQueens(int n) {
		List<Boolean> res = new ArrayList<Boolean>();
		int[] current = new int[n];
		helper(res,0,n, current);
		return res.size();
    }
	
	public void helper(List<Boolean> result,int index,int n, int[] current){
		if(n==index){
			result.add(true);
			return;
		}
		for(int i=0;i<n;i++){
			current[index]=i;
			if(validate(current, index))
				helper(result, index+1, n, current);
			else{
				current[index]=0;
			}
		}
	}
	
	public boolean validate(int[] current, int index){
		for(int i=0;i<index;i++){
			if(current[i]==current[index]) return false;
			else if((index-i)==Math.abs(current[index]-current[i]))
				return false;
		}
			return true;
	}
}
