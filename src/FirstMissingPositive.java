
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if(A.length==0) return 1;
		for(int i=0;i<A.length;i++){
			if(A[i]-1<A.length &&A[i]>=1&&A[i]!=i+1){
				if(A[i]>=1&&A[A[i]-1]==A[i]) continue;
				int temp=A[i];
				A[i]=A[A[i]-1];
				A[temp-1] = temp;
				i--;
			}
		}
		for(int i=0;i<A.length;i++){
			if(A[i]!=i+1) return i+1;
		}
		return A.length+1;
	}
}
