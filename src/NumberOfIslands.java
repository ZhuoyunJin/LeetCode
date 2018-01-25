
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
	public static void main(String[] args) {
		char[][] arr = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','1'}};
		//char[][] arr = new char[][]{{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		NumberOfIslands n = new NumberOfIslands();
		System.out.println(n.numIslands(arr));
	}

}
