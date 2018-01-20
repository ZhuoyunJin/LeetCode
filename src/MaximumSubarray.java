
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A.length==0) return 0;
		int[] sum = new int[A.length];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			if(i==0) sum[i]=A[i];
			else{
				sum[i]=Math.max(sum[i-1]+A[i], A[i]);
			}
			max=Math.max(max, sum[i]);
		}
		return max;
	}
	
	public int maxSubArraySumDC(int[] a, int l, int h){  
        if(l == h){  
            return a[l];  
        }  
        int m = (l+h)/2;  
        return Math.max(Math.max(maxSubArraySumDC(a, l, m), maxSubArraySumDC(a, m+1, h)), maxCrossingSum(a, l, m, h));  
    }  
  
    private int maxCrossingSum(int[] a, int l, int m, int h) {  
        int sum = 0;  
        int leftSum = Integer.MIN_VALUE;  
        for(int i=m; i>=l; i--){  
            sum += a[i];  
            if(sum > leftSum){  
                leftSum = sum;  
            }  
        }  
          
        sum = 0;  
        int rightSum = Integer.MIN_VALUE;  
        for(int i=m+1; i<=h; i++){  
            sum += a[i];  
            if(sum > rightSum){  
                rightSum = sum;  
            }  
        }  
          
        return leftSum + rightSum;  
    }  
}
