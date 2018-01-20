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
}
