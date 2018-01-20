
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m=grid.length, n=grid[0].length;
		if(m==0 || n==0) return 0;
		int mat[][] = new int[m][n];
		mat[m-1][n-1]=grid[m-1][n-1];
		for(int i=m-1;i>=0;i--){
			for(int j=n-1;j>=0;j--){
				if(i==m-1&&j==n-1) {
					mat[m-1][n-1]=grid[m-1][n-1];
					continue;
				}
				int right = j==n-1?Integer.MAX_VALUE:mat[i][j+1];
				int down = i==m-1?Integer.MAX_VALUE:mat[i+1][j];
				mat[i][j]= grid[i][j]+Math.min(right, down);
			}
		}
		return mat[0][0];
	}
}
