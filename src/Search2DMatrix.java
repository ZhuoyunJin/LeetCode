
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length, n=matrix[0].length;
		int rowIndex=findRow(matrix, target, 0, m-1);
		return findCol(matrix,target,rowIndex,0,n-1);
	}
	
	public int findRow(int[][] matrix, int target, int from, int to){
		if(from==to) return from;
		if(from+1==to){
			if(matrix[to][0]>target) return from;
			else return to;
		}
		int mid=(from+to)/2;
		if(matrix[mid][0]<target){
			return findRow(matrix, target, mid, to);
		}else if(matrix[mid][0]>target){
			return findRow(matrix, target, from, mid);
		}else{
			return mid;
		}
	}

	public boolean findCol(int[][] matrix, int target, int row, int from, int to){
		if(from==to) return (target==matrix[row][to]);
		if(from+1==to)
			return (target==matrix[row][from]||target==matrix[row][to]);
		int mid=(from+to)/2;
		if(matrix[row][mid]<target){
			return findCol(matrix, target, row, mid, to);
		}else if(matrix[row][mid]>target){
			return findCol(matrix, target, row, from, mid);
		}else{
			return true;
		}
	}
}
