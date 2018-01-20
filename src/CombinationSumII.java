import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		List<Integer> current = new ArrayList<Integer>();
		helper(candidates, target, 0, res,current);
		return res;
	}
	
	public void helper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> current){
		if(target==0){
			res.add(new ArrayList<Integer>(current));
		}
		if(index>=candidates.length||candidates[index]>target){
			return;
		}
		for(int i=index;i<candidates.length&&candidates[i]<=target;i++){
			if(i!=index&&candidates[i]==candidates[i-1]) continue;
			current.add(candidates[i]);
			helper(candidates, target-candidates[i], i+1, res, current);
			current.remove(current.size()-1);
		}
	}
}
