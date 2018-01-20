
public class JumpGame {
	public boolean canJump2(int[] A) {
		return helper(A, 0);
	}
	
	public boolean helper(int[] A, int start){
		if(start>A.length-1) return true;
		if(A[start]==0) return false;
		int first = A[start];
		for(int i=first;i>0;i--){
			if(helper(A, start+i)) return true;
			System.out.println("re");
		}
		return false;
	}
	
	public boolean canJump3(int[] A) {
		boolean[] dp = new boolean[A.length];
		for(int i=A.length-1;i>=0;i--){
			if(A[i]+i>A.length-1) dp[i]=true;
			else{
				for(int j=1;j<=A[i]&&i+j<A.length;j++){
					if(dp[j]){
						dp[i]=true;
						break;
					}
				}
			}
		}
		return dp[0];
	}
	
	public boolean canJump(int[] A) {
		int max=0;
		for(int i=0;i<A.length;i++){
			if(A[i]+i>max) max=A[i]+i;
			if(A[i]+i > A.length-1) return true;
			if(max==i&&A[i]==0&&i!=A.length-1) return false;
		}
		return true;
	}
}
