package Google;
/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class PerfectSquares {
	public int numSquares(int n) {
		int[] num = new int[n+1];
		for(int i=1;i<=n;i++){
			num[i]=Integer.MAX_VALUE;
		}
		num[1]=1;
		for(int i=2;i<=n;i++){
			int squareRoot = (int)Math.sqrt(i);
			if(i-squareRoot*squareRoot==0){
				num[i]=1;
				continue;
			}
			int j=1;
			while(j*j<=i){
				num[i]=Math.min(num[i], num[i-j*j]+1);
				j++;
			}
		}
		return num[n];
	}

	//time exceeded
	public int numSquares2(int n) {
		if(n==1) return 1;
		if(n==0) return 0;
		int largestSquareRoot = 1;
		while(Math.pow((largestSquareRoot+1), 2) <= n){
			largestSquareRoot++;
		}

		int result = Integer.MAX_VALUE;
		for(int i=1;i<=largestSquareRoot;i++){
			int currentResult = numSquares(n-i*i)+1;
			result = currentResult<result? currentResult:result;
		}
		return result;
	}

	public int numSquares3(int n) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[0] = 0;
		for(int i=2;i<=n;i++){
			int largestSquareRoot = (int)Math.sqrt(i);
			int result = Integer.MAX_VALUE;
			for(int j=1;j<=largestSquareRoot;j++){
				int currentResult = dp[n-j*j]+1;
				result = currentResult<result? currentResult:result;
			}
			dp[i] = result;
		}
		for(int i: dp){
			System.out.println(i);
		}
		return dp[n];
	}

	public static void main(String[] args){
		PerfectSquares test = new PerfectSquares();
		test.numSquares3(12);
	}
}
