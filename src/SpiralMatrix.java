import java.util.ArrayList;
import java.util.List;


public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list =new ArrayList<Integer>();
		if(matrix.length==0) return list;
		int m=matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];
		int x=0,y=0;
		int count=1;
		list.add(matrix[0][0]);
		if(m*n==1) return list;
		visited[0][0]=true;
		while(true){
			//right
			for(y=y+1;;y++){
				if((y>n-1) || (visited[x][y]==true)) {
					y--;
					break;
				}
				list.add(matrix[x][y]);
				visited[x][y]= true;
				count++;
				if(count==m*n) return list;
				
			}
			//down
			for(x=x+1;;x++){
				if((x>m-1) || (visited[x][y]==true)) {
					x--;
					break;
				}
				list.add(matrix[x][y]);
				visited[x][y]= true;
				count++;
				if(count==m*n) return list;
				
			}
			//left
			for(y=y-1;;y--){
				if((y<0) || (visited[x][y]==true)) {
					y++;
					break;
				}
				list.add(matrix[x][y]);
				visited[x][y]= true;
				count++;
				if(count==m*n) return list;
				
			}
			//up
			for(x=x-1;;x--){
				if((x<0) || (visited[x][y]==true)) {
					x++;
					break;
				}
				list.add(matrix[x][y]);
				visited[x][y]= true;
				count++;
				if(count==m*n) return list;
				
			}
			
		}

	}
}
