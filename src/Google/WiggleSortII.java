package Google;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		if(nums.length<=1) return;
		Arrays.sort(nums);
		int mid = (nums.length -1)/2;
		int right = nums.length-1;
		int[] temp = new int[nums.length];
		boolean odd=true;
		for(int i=0;i<nums.length;i++){
			if(odd) temp[i] = nums[mid--];
			else temp[i] = nums[right--];
			odd = !odd;
		}
		for(int i=0;i<nums.length;i++){
			nums[i] = temp[i];
		}
	}
}
