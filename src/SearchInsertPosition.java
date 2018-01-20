
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		if(A.length==0) return 0;
		int left=0,right=A.length-1;
		while(left<right){
			int mid=(left+right)/2;
			if(A[mid]>=target){
				right=mid;
			}else{
				left=mid+1;
			}
		}
		return target<=A[left]?left:left+1;
	}
}
