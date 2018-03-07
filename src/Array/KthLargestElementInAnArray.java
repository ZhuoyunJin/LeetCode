package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ArrayComparator implements Comparator<Integer>
{
    @Override
    public int compare(Integer x, Integer y)
    {
        if (x < y)
        {
            return 1;
        }
        if (x > y)
        {
            return -1;
        }
        return 0;
    }
}

public class KthLargestElementInAnArray {
	public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
	
	
	public int findKthLargest2(int[] nums, int k) {
        Comparator comparator = new ArrayComparator();
		PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
       // int nthSmallest = (nums.length - k) + 1;
        for(int i : nums) {
        	queue.offer(i);
        	if(queue.size() > k)
        		queue.poll();
        }
       
        //System.out.println(queue);
        return queue.peek();
    }
	public static void main(String[] args) {
		KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
		kthLargestElementInAnArray.findKthLargest2(new int[] {3, 5, 8,1,3}, 1);
	}

}
