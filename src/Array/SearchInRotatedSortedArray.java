package Array;

public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		if(A.length==0) return -1;
		if(A.length==1) return A[0]==target?0:-1;
		int left=0,right=A.length-1;
		while(left<right){
			if(left==right-1){
				if(A[right]==target) return right;
				else if(A[left]==target) return left;
				else return -1;
			}
			int middle=(left+right)/2;
			if(A[middle]==target) return middle;
			if(A[left]<A[middle]){
				if(A[left]<=target && target<A[middle]){
					right=middle-1;
				}else{
					left=middle+1;
				}
			}else{
				if(A[middle]<target&&target<=A[right]){
					left=middle+1;
				}else{
					right=middle-1;
				}
			}
		}

		return (A[left]==target?left:-1);
	}

	public int search2(int[] nums, int target) {
		if(nums == null || nums.length ==0) return -1;
		return searchHelper(nums, target, 0, nums.length-1);
	}

	public int searchHelper(int[] nums, int target, int start, int end) {
		if(start > end) return -1;
		//if(start == end) return nums[start] == target? start: -1;
		int midIndex = (start+end)/2;
		if(nums[midIndex] == target) return midIndex;
		int left, right;
		//left part: start - (mid-1);
		if(midIndex -1 < 0)
			left = -1;
		else if(nums[start] <= nums[midIndex-1] && (nums[start]>target || nums[midIndex-1] < target))
			left = -1;
		else
			left =searchHelper(nums, target, start, midIndex-1);
		//right part: (mid+1) - end
		if(midIndex+1 > nums.length-1)
			right = -1;
		else if(nums[midIndex+1] <= nums[end] && (nums[midIndex+1]>target || nums[end] < target))
			right = -1;
		else
			right = searchHelper(nums, target, midIndex+1, end);
		return -(left*right);
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
		System.out.println(test.search2(new int[] {1,3}, 2));
	}
}
