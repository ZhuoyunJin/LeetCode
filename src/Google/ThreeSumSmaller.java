package Google;

import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		int count=0;
		if(nums.length < 3) return 0;
		//sort array
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			int newTarget = target - nums[i];
			int left = i+1, right = nums.length-1;
			while(left<right){
				if((nums[left]+nums[right])<newTarget){
					count+=(right-left);
					left++;
				}else{
					right--;
				}
			}
		}
		return count;
	}
}
