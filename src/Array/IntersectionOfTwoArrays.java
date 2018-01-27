package Array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<Integer>();
		for(int i : nums1){
			set.add(i);
		}
		Set<Integer> intersection = new HashSet<Integer>();
		for(int i : nums2){
			if(set.contains(i))
				intersection.add(i);
		}
		int[] result = new int[intersection.size()];
		int Index = 0;
		for(int i: intersection){
			result[Index++]=i;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
