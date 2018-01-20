
public class UniquePaths {
	public int uniquePaths1(int m, int n) {
		if(m==0||n==0) return 0;
		if(m==1||n==1) return 1;
		int[][] mat=new int[m][n];
		for(int i=0;i<n;i++){
			mat[m-1][i]=1;
		}
		for(int i=0;i<m;i++){
			mat[i][n-1]=1;
		}
		for(int i=m-2;i>=0;i--){
			for(int j=n-2;j>=0;j--){
				mat[i][j]=mat[i][j+1]+mat[i+1][j];
			}
		}
		return mat[0][0];
	}
	//exceed time limit
	public int uniquePaths2(int m, int n) {
		int currentX=0,currentY=0;
		if(currentX<m-1 && currentY<n-1) return uniquePaths2(n-1, m)+uniquePaths2(n, m-1);
		else return 1;
	}
}
