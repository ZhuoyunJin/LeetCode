
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] arr = new int[n][n];
		if(n==0) return arr;
		if(n==1) return new int[][]{{1}};
		int x=0,y=0;
		int count = 1;
		arr[0][0]=1;
		while(true){
			//right
			for(y=y+1;;y++){
				if((y>n-1)||arr[x][y]!=0) {
					y--;
					break;
				}
				arr[x][y]= ++count;
				if(count==n*n) return arr;

			}
			//down
			for(x=x+1;;x++){
				if((x>n-1)||arr[x][y]!=0) {
					x--;
					break;
				}
				arr[x][y]= ++count;
				if(count==n*n) return arr;

			}
			//left
			for(y=y-1;;y--){
				if((y<0)||arr[x][y]!=0 ) {
					y++;
					break;
				}
				arr[x][y]= ++count;
				if(count==n*n) return arr;

			}
			//up
			for(x=x-1;;x--){
				if((x<0)||arr[x][y]!=0) {
					x++;
					break;
				}
				arr[x][y]= ++count;
				if(count==n*n) return arr;

			}

		}
	}
}
