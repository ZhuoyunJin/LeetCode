import java.util.ArrayList;
import java.util.List;


public class NQueens {
	public List<String[]> solveNQueens(int n) {
		List<String[]> resultList = new ArrayList<String[]>();
		int[] current = new int[n];
		helper(resultList,0,n, current);
		return resultList;
    }
	
	public void helper(List<String[]> result,int index,int n, int[] current){
		if(n==index){
			addResult(current, result);
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
	
	public void addResult(int[] current, List<String[]> res){
		String[] strings = new String[current.length];
		
		for(int i=0;i<current.length;i++){
			StringBuffer sb = new StringBuffer();
			int temp = current[i];
			for(int j=0;j<current.length;j++){
				if(j==temp) sb.append('Q');
				else sb.append('.');
			}
			strings[i]=sb.toString();
		}
		res.add(strings);
	}
}
