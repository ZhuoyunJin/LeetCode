
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
}
