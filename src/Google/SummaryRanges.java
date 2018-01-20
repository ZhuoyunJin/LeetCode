package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		int head=0, tail=0;
		for(int i=0;i<nums.length;i++){
			head=nums[i];
			for(int j=i;j<nums.length;j++){
				if(j==nums.length-1 || nums[j]!=nums[j+1]-1){
					tail=nums[j];
					i=j;
					break;
				}
				else
					continue;
			}
			if(head==tail)
				list.add(""+head);
			else
				list.add(""+head+"->"+tail);
		}
		return list;
	}
}
