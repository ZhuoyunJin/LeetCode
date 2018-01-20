import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num.length<3) return result;
		for(int i=0;i<num.length-2;i++){
			if(i!=0 &&num[i]==num[i-1]) continue;
			int target = -num[i];
			int start = i+1;
			int end = num.length-1;
			while(start<end){
				if(num[start]+num[end]==target){
					List<Integer> temp=new ArrayList<Integer>();
					result.add(temp);
					temp.add(num[i]);
					temp.add(num[start]);
					temp.add(num[end]);
					do{
						start++;
					}while(start<num.length && num[start]==num[start-1]);
					do{
						end--;
					}while(end>i && num[end]==num[end+1]);
				}else if(num[start]+num[end]<target){
					start++;
				}else{
					end--;
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSumOriginal(int[] num) {
		Arrays.sort(num);
		return twoSum(num);
	}

	public List<List<Integer>> twoSum(int[] num){
		if(num.length<3) return new ArrayList<List<Integer>>();
		//create hash
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0;i<num.length;i++){
			if(hashMap.containsKey(num[i])){
				int x = hashMap.get(num[i]);
				hashMap.put(num[i], ++x);
			}else{
				hashMap.put(num[i], 1);
			}
		}
		System.out.println(hashMap);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int x=0;x<num.length-2;x++){
			if(x>0 && num[x]==num[x-1])
				continue;
			for(int i=x+1; i<num.length-1;i++){
				if(i>x+1 &&num[i]==num[i-1]) continue;
				int temp = 0-num[x]-num[i];
				if(hashMap.containsKey(temp)){
					if(temp<num[i]) continue;
					else if(temp==num[i] && hashMap.get(temp)<2) continue;
					else if(temp==num[i] && temp==num[x] && hashMap.get(temp)<3) continue;
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[x]);
					list.add(num[i]);
					list.add(temp);
					result.add(list);
				}
			}
			
		}
		return result;
	}
//
//	public int[] sort(int[] input){
//		if(input.length<2) return input;
//		int middle = (input.length-1)/2;
		//int[] list1=System.arraycopy(arg0, arg1, arg2, arg3, arg4);
		//return mergeSort;
//	}
}
