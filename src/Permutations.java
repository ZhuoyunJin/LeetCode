import java.util.ArrayList;
import java.util.List;


public class Permutations {
	public List<List<Integer>> permute(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		return helper(num, 0, result);
	}

	public List<List<Integer>> helper(int[] num,int index,List<List<Integer>> result){
		if(index>=num.length-1){
			List<List<Integer>> newlist = new ArrayList<List<Integer>>();
			List<Integer> list = new ArrayList<Integer>();
			list.add(num[index]);
			newlist.add(list);
			return newlist;
		}else{
			List<List<Integer>> newlist = new ArrayList<List<Integer>>();
			newlist=helper(num, index+1, result);
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			for(List<Integer> ls:newlist){
				for(int i=0;i<=ls.size();i++){
					List<Integer> temp= new ArrayList<Integer>(ls);
					int currentnumber=num[index];
					temp.add(i, currentnumber);
					list.add(temp);
				}
			}
			return list;
		}
	}

}
