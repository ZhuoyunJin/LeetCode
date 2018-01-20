import java.util.HashMap;
import java.util.Map;


public class twoSum {
	
public int[] twoSum1(int[] numbers, int target) {
	int[] results = new int[2];
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<numbers.length;i++){
			int difference = target - numbers[i];
			if(map.containsKey(difference)){
				results[0] = map.get(difference);
				results[1] = i+1;
				return results;
			}else{
				map.put(numbers[i], i+1);
			}
			
		}
		return results;
    }
}
