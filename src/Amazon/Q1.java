package Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1 {
	//timeout
	static int[] counts2(int[] nums, int[] maxes) {
		int n = nums.length;
		int m = maxes.length;

		int[] result = new int[m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(nums[i]<=maxes[j])
					result[j]++;
			}
		}
		return result;
	}

	static int[] counts3(int[] nums, int[] maxes) {
		//int n = nums.length;
		int m = maxes.length;
		
		int max=0;
		for(int i : nums) {
			if(i>max) max=i;
		}
		
		int[] temp = new int[max+1];
		for(int i : nums) {
			temp[i]++;
		}
		
		for(int i= 1;i<temp.length;i++) {
			temp[i] += temp[i-1];
		}
		
		int[] result = new int[m];
		for(int i=0;i<maxes.length;i++) {
			if(maxes[i]>max)
				result[i] = temp[max];
			else
				result[i] = temp[maxes[i]];
		}
		return result;
	}
	
	static int[] counts(int[] nums, int[] maxes) {
		if (nums == null || maxes == null) {
            return new int[]{-1};
        }
        int[] result = maxes.clone();
        Arrays.sort(nums);
        Arrays.sort(maxes);
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (i < nums.length && j < maxes.length) {
            while(i < nums.length && nums[i] <= maxes[j]) {
                i++;
                count++;
            }
            map.put(maxes[j], count);
            j++;
        }
        while (j < maxes.length) {
            map.put(maxes[j], count);
            j++;
        }
        for (int k = 0; k < result.length; k++) {
            result[k] = map.get(result[k]);
        }
        return result;
	}
	
	public static void main(String[] args) {
		Q1 test = new Q1();
		int[] arr = new int[] {4,1,4,2,4,2};
		int[] maxes = new int[] {3,5};
		int[] rest= test.counts(arr, maxes);
		for(int i : rest) {
			System.out.println(i);
		}
	}

}
