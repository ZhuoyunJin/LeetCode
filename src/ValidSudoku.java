
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if(board.length!=9 || board[0].length!=9) return false;
		//check row
		for(int i=0;i<9;i++){
			int[] row = new int[10];
			for(int j=0;j<9;j++){
				if(board[i][j]=='.') continue;
				if(row[board[i][j]-'0']==1) return false;
				else
					row[board[i][j]-'0']=1;
			}
		}
		//check column
		for(int i=0;i<9;i++){
			int[] row = new int[10];
			for(int j=0;j<9;j++){
				if(board[j][i]=='.') continue;
				if(row[board[j][i]-'0']==1) return false;
				else
					row[board[j][i]-'0']=1;
			}
		}
		//check square
		for(int i=0;i<9;i=i+3){
			for(int j=0;j<9;j=j+3){
				int[] row = new int[10];
				for(int m=0;m<3;m++){
					for(int n=0;n<3;n++){
						if(board[i+m][j+n]=='.') continue;
						if(row[board[i+m][j+n]-'0']==1) return false;
						else 
							row[board[i+m][j+n]-'0']=1;
					}
				}

			}
		}
		return true;
	}
}
