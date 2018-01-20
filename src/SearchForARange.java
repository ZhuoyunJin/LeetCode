
public class SearchForARange {
	public int[] searchRange(int[] A, int target) {
		int[] res=new int[]{-1,-1};
		if(A.length==0) return res;
		return searchRange(A, target,0, A.length-1);
	}
	public int[] searchRange(int[] A, int target, int left, int right) {
		int[] res=new int[]{-1,-1};
		if(left==right) return A[left]==target?new int[]{left,right}:res;
		int mid=(left+right)/2;
		if(A[mid]==target && A[mid+1]==target){
			int resLeft=searchRange(A,target,left,mid)[0];
			int resRight=searchRange(A,target,mid+1,right)[1];
			return new int[]{resLeft,resRight};
		}else if(A[mid]>=target){
			return searchRange(A,target,left,mid);
		}else{
			return searchRange(A,target,mid+1,right);
		}
	}
}
