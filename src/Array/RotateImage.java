package Array;

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n=matrix.length;
		if(n==0) return;
		int times=n/2;
		for(int i=0;i<times;i++){
			for(int j=i;j<n-1-i;j++){
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
}
