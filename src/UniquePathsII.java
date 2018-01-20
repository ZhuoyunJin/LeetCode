
public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m=obstacleGrid.length, n=obstacleGrid[0].length;
		if(m==0||n==0) return 0;
		int[][] mat=new int[m][n];
		mat[m-1][n-1]=obstacleGrid[m-1][n-1]==1?0:1;
		for(int i=n-2;i>=0;i--){
			mat[m-1][i]=obstacleGrid[m-1][i]==1?0:mat[m-1][i+1];
		}
		for(int i=m-2;i>=0;i--){
			mat[i][n-1]=obstacleGrid[i][n-1]==1?0:mat[i+1][n-1];
		}
		for(int i=m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				if(obstacleGrid[i][j]==1)
					mat[i][j]=0;
				else
					mat[i][j]=mat[i][j+1]+mat[i+1][j];
			}
		}

		return mat[0][0];
	}
}
