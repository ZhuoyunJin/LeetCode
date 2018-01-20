
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		recursor(board,0,0);
//		for(int i=0;i<9;i++){
//			for(int j=0;j<9;j++){
//				//if(board[i][j]=='.'){
//					System.out.print(board[i][j]);;
//				//}
//			}
//			System.out.println();
//		}
	}

	public boolean recursor(char[][] board, int ii, int jj){
		for(int i=ii;i<9;i++){
			for(int j=jj;j<9;j++){
				if(board[i][j]=='.'){
					for(int k=1;k<=9;k++){
						board[i][j]=(char)('0'+k);
						if(isValidSudoku(board) && recursor(board, i, j)){
							return true;
						}
					}
					board[i][j]='.';
					return false;
				}

			}
			jj=0;
		}
		return true;
	}

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
