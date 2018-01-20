import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num.length<4) return result;
		for(int i=0;i<num.length-3;i++){
			if(i!=0 && num[i]==num[i-1]) continue;
			int x = num[i];
			for(int j=i+1;j<num.length-2;j++){
				if(j!=i+1 && num[j]==num[j-1]) continue;
				int y = num[j];
				int remaining = target-x-y;
				int start=j+1, end=num.length-1;
				while(start<end){
					if(num[start]+num[end]==remaining){
						List<Integer> temp=new ArrayList<Integer>();
						temp.add(x);
						temp.add(y);
						temp.add(num[start]);
						temp.add(num[end]);
						result.add(temp);
						do{
						start++;
						if(start>=num.length) break;
						}while(num[start]==num[start-1]);
						do{
						end--;
						if(end<=j) break;
						}while(num[end]==num[end+1]);
					}else if(num[start]+num[end]<remaining){
						start++;
					}else{
						end--;
					}
				}
			}
		}
		return result;
	}
}
