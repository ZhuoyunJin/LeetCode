import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public String getPermutation(int n, int k) {
		StringBuilder sb=new StringBuilder();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<=n;i++){
			list.add(i);
		}
		int total = 1;
		for(int i=1;i<=n;i++){
			total*=i;
		}
		if(k>total) return "";
		k--;
		for(int i=1;i<=n;i++){
			total=total/(n-i+1);
			int temp=k/total;
			k=k-temp*total;
			sb.append(list.get(temp));
			list.remove(temp);
		}
		return sb.toString();
	}
}
