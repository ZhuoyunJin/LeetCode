package Google;
/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Note:n and k are non-negative integers.
 */
public class PaintFence {
	public int numWays(int n, int k) {
		if(n==0) return 0;
		if(n==1) return k;
		if(n==2) return k*k;
		int[] same = new int[n];
		int[] diff = new int[n];
		same[1]=k;
		diff[1]=k*(k-1);
		for(int i=2;i<n;i++){
			//use the same color
			same[i]=diff[i-1];
			//use a different color
			diff[i]=(same[i-1]+diff[i-1])*(k-1);
		}
		return (same[n-1]+diff[n-1]);
	}
}
