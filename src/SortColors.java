
public class SortColors {
	public void sortColors(int[] A) {
		if(A.length<=1) return;
		int ptrLeft=0, ptrRight=A.length-1;
		int i=0;
		while(i<=ptrRight){
			if(i>=ptrRight) break;
			if(A[i]==0){
				if(i!=ptrLeft){
					A[i]=A[ptrLeft];
					A[ptrLeft]=0;
				}else{
					i++;
				}
				ptrLeft++;
			}else if(A[i]==2){
				A[i]=A[ptrRight];
				A[ptrRight]=2;
				ptrRight--;
			}else{
				i++;
			}
		}
		if(A[ptrLeft]>A[ptrRight]){
			int temp=A[ptrLeft];
			A[ptrLeft]=A[ptrRight];
			A[ptrRight]=temp;
		}
	}
}
