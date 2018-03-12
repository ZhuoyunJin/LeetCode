package Array;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int counter = 0;
		if(grid.length==0 || grid[0].length==0) return 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				char currentChar = grid[i][j];
				if(currentChar=='1'){
					counter++;
					clear(i, j, grid);
				}
			}
		}
		return counter;
	}

	public void clear(int i, int j, char[][] grid){
		//System.out.println(String.format("i=%d, j=%d", i, j));
		if(grid[i][j]=='1' ){
			grid[i][j]= '-';
			//up
			if(i>0) clear(i-1, j, grid);
			//down
			if(i<grid.length-1) clear(i+1, j, grid);
			//left
			if(j>0) clear(i, j-1, grid);
			//right
			if(j<grid[0].length-1) clear(i, j+1, grid);
		}
	}

	public int numIslands2(char[][] grid) {
		if(grid == null) return 0;
		int m = grid.length;
		if(m==0) return 0;
		int n= grid[0].length;
		if(n == 0) return 0;
		int counter = 0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == '1') {
					counter++;
					helper(grid, i, j);
				}
			}
		}
		return counter;
	}
	
	public void helper(char[][] grid, int i, int j) {
		if(grid[i][j] != '1') return;
		grid[i][j] = '-';
		//up
		if(i > 0) helper(grid, i-1, j);
		//down
		if(i<grid.length-1) helper(grid, i+1,j);
		//left
		if(j > 0) helper(grid, i,j-1);
		//right
		if(j<grid[0].length -1) helper(grid, i, j+1);
	}
	public static void main(String[] args) {
		char[][] arr = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
		//char[][] arr = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		NumberOfIslands n = new NumberOfIslands();
		System.out.println(n.numIslands2(arr));
	}

}
