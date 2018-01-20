
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if(matrix.length==0) return;
		boolean colNeedSet=false, rowNeedSet=false;
		int m=matrix.length,n=matrix[0].length;
		for(int i=0;i<m;i++){
			if(matrix[i][0]==0){
				colNeedSet=true;
				break;
			}
		}
		for(int i=0;i<n;i++){
			if(matrix[0][i]==0){
				rowNeedSet=true;
				break;
			}
		}
		for(int i=1;i<matrix.length;i++){
			for(int j=1;j<matrix[0].length;j++){
				if(matrix[i][j]==0){
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}
		for(int i=1;i<m;i++){
			if(matrix[i][0]==0){
				for(int j=1;j<n;j++){
					matrix[i][j]=0;
				}
			}
		}
		for(int i=1;i<n;i++){
			if(matrix[0][i]==0){
				for(int j=1;j<m;j++){
					matrix[j][i]=0;
				}
			}
		}
		if(colNeedSet){
			for(int i=0;i<m;i++){
				matrix[i][0]=0;
			}
			
		}
		if(rowNeedSet){
			for(int i=0;i<n;i++){
				matrix[0][i]=0;
			}
		}
	}
}
