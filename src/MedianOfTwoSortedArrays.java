import java.util.Arrays;


public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;//1
		int n = B.length;//1
		if(m==0) return findMedian(B);
		if(n==0) return findMedian(A);
		int[] C = new int[m+n];
		int ptrA = 0;
		int ptrB = 0;
		int ptrC = 0;
		while((ptrA<m) && (ptrB<n)){
			if(A[ptrA]<B[ptrB]){
				C[ptrC]=A[ptrA];
				ptrA++;
				ptrC++;
			}else{
				C[ptrC]=B[ptrB];
				ptrB++;//1
				ptrC++;//1
			}
		}
		if(ptrA==m){
			while(ptrB<n){
				C[ptrC]=B[ptrB];
				ptrB++;
				ptrC++;
			}
		}else{
			while(ptrA<m){
				C[ptrC]=A[ptrA];
				ptrA++;
				ptrC++;
			}
		}
		return findMedian(C);
	}
	
	public double findMedian(int A[]){
		int mid = A.length/2;//1
		if(A.length%2==0){
			int median = A[mid]+A[mid-1];
			return median==0?0:(median/2.0);
		}else{
			return A[mid];
		}
	}
	
	public int[] merge(int[] A, int[] B){
		int[] C=new int[A.length+B.length];
		int ptrA=0;
		int ptrB=0;
		int ptrC=0;
		while(ptrA<A.length && ptrB<B.length){
			if(A[ptrA]<B[ptrB]) C[ptrC++]=A[ptrA++];
			else C[ptrC++]=B[ptrB++];
		}
		if(ptrA==A.length){
			while(ptrB<B.length){
				C[ptrC++]=B[ptrB++];
			}
		}else{
			while(ptrA<A.length){
				C[ptrC++]=A[ptrA++];
			}
		}
		return C;
	}
}
