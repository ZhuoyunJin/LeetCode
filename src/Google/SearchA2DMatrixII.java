package Google;
/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchA2DMatrixII {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length, n=matrix[0].length;
	    if(m==0 && n==0) return false;
	    int i=m-1,j=0;
	    while(i>=0 && j<n){
	    	if(matrix[i][j]==target) return true;
	    	else if(matrix[i][j]>target) i--;
	    	else j++;
	    }
	    return false;
	}
	
	public boolean searchMatrix2(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
	    return search(matrix, target, 0, 0, matrix.length-1, matrix[0].length-1);
	}
	
	public boolean search(int[][] matrix, int target, int rLeftUp, int cLeftUp, int rRightDown, int cRightDown){
		if(rLeftUp <0 || rLeftUp>=matrix.length) return false;
		else if (rRightDown<0||rRightDown>=matrix.length) return false;
		else if(cLeftUp<0||cLeftUp>=matrix[0].length) return false;
		else if(cRightDown<0||cRightDown>=matrix[0].length) return false;
		else if(rLeftUp>rRightDown || cLeftUp>cRightDown) return false;
		int rMid = (rLeftUp+rRightDown)/2;
		int cMid = (cLeftUp+cRightDown)/2;
		if(matrix[rMid][cMid] == target) return true;
		else if(matrix[rMid][cMid] < target)
			return search(matrix, target, rMid+1, cLeftUp, rRightDown, cRightDown)||search(matrix,target,rLeftUp, cMid+1, rMid,cRightDown);
		else
			return search(matrix, target, rLeftUp, cLeftUp, rRightDown, cMid-1)||search(matrix,target,rLeftUp, cMid, rMid-1,cRightDown);
	}
}
