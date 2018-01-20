import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		List<Integer> current = new ArrayList<Integer>();
		helper(candidates, target, 0, res, current);
		return res;
	}

	public void helper(int[] candidates, int target, int index, List<List<Integer>> res, List<Integer> current){
		if(target==0){
			res.add(new ArrayList<Integer>(current));
			return;
		}

		for(int i=index;i<candidates.length&&candidates[i]<=target;i++){
			if(i!=index&&candidates[i]==candidates[i-1]) continue;
			current.add(candidates[i]);
			helper(candidates, target-candidates[i], i, res, current);
			current.remove(current.size()-1);
		}
	}

	//		public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	//		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
	//		prev.add(new ArrayList<Integer>());
	//		return combinationSumRecursive(candidates,target,0,prev);
	//	}
	//
	//	public ArrayList<ArrayList<Integer>> combinationSumRecursive(int[] candidates, int target, int i, ArrayList<ArrayList<Integer>> prev){
	//		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	//		if(target==0){
	//			for(ArrayList<Integer> temp:prev){
	//				ArrayList<Integer> temp1 = new ArrayList<Integer>(temp);   
	//				res.add(temp1);
	//			}    
	//			return res;
	//		}    
	//		for(int j=i;j<candidates.length && candidates[j]<=target;j++){
	//			for(ArrayList<Integer> temp:prev)
	//				temp.add(candidates[j]);    
	//			ArrayList<ArrayList<Integer>> next = combinationSumRecursive(candidates,target-candidates[j],j,prev);
	//			if(next.size()>0)
	//				res.addAll(next);
	//			for(ArrayList<Integer> temp:prev)
	//				temp.remove(temp.size()-1);
	//		}
	//		return res;
	//	}

}
