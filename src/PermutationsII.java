import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		Arrays.sort(num);
		boolean[] visited = new boolean[num.length];
		helper(num, 0, result,current, visited);
		return result;
	}

	public void helper(int[] num,int index,List<List<Integer>> result, List<Integer> current,boolean[] visited){
		if(index>=num.length){
			result.add(new ArrayList<Integer>(current));
		}
		HashMap<Integer, Boolean> hashtable=new HashMap<Integer, Boolean>();
		for(int i=0;i<num.length;i++){
			if(hashtable.containsKey(num[i])) continue;
			if(visited[i]) continue;
			else{
				current.add(num[i]);
				visited[i]=true;
				hashtable.put(num[i], true);
				helper(num, index+1, result, current, visited);
				current.remove(current.size()-1);
				visited[i]=false;
			}
		}
	}
}
