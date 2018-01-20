
public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] A) {
        if(A.length==0) return 0;
        int res=1;
        for(int k=1;k<A.length;k++){
            if(A[k]!=A[k-1]) {
            	A[res] = A[k];
            	res++;
            }
        }
        return res;
    }
}
