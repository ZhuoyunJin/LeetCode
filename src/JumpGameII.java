import java.util.Queue;


public class JumpGameII {
	
	public int jump(int[] A) {
		if(A.length<=1) return 0;
		int maxReachCurrent=0;
		int maxReachNext=A[0];
		int steps=0;
		for(int i=1;i<A.length;i++){
			if(i>maxReachCurrent){
				steps++;
				maxReachCurrent=maxReachNext;
				if(maxReachCurrent>=A.length-1) return steps;
			}
			maxReachNext=Math.max(maxReachNext, i+A[i]);
		}
		return steps;
	}
	
	/* out of time limit
	public int jump(int[] A) {
		return helper(A, 0,0);
	}

	public int helper(int[] A, int index,int jump){
		if(index>=A.length) return Integer.MAX_VALUE;
		if(index==A.length-1){
			//System.out.println(jump);
			return jump;
		}
		int step = A[index];
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=step;i++){
			int temp = helper(A, index+i, jump+1);
			if(temp<min) min=temp;
		}
		return min;
	}
	 */

	/*
	public int jump(int[] A) {
		int curMax = 0; 
		int nextMax = 0; 
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			if (i > curMax) {
				curMax = nextMax;
				ans++;
			}
			nextMax = Math.max(nextMax,A[i] + i);
		}
		return ans;
	}
	 */
	
}
