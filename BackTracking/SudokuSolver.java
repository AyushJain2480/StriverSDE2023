// There are 2 questions 
// 1st A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
// Leetcode 

class Solution {
    public boolean isValidSudoku(char[][] board) {
         for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9 ; col++) {
                if (board[row][col] != '.') {
                    char ch = board[row][col];
                    board[row][col] = '.';
                    if (!isValid(board, row, col, ch)) {
                        return false;
                    } else {
                        board[row][col] = ch;
                    }
                }
            }
        }
        return true;
    }
    
    boolean isValid(char[][] board , int row , int col, char ch){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == ch)
                return false;
    
            if(board[row][i] == ch)
                return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
}


// Coding Ninjas 
// you need to find out wheather there exists a way  to fill all the empty cells  with some digit 1 - 9 such that the final solution will be valid sudoku
// there is a difference bw both questions


public class Solution {

	public static boolean isItSudoku(int board[][]) {
        for(int i = 0; i < 9; i++){
            for(int  j = 0; j < 9; j++){
                
                if(board[i][j] == 0){
                    
                    for(int k = 1; k <= 9; k++){
                        
                        if(isValid(board, i , j, k)){
                            
                            board[i][j] = k;
                            
                            if(isItSudoku(board))
                                return true;
                            else
                                board[i][j] = 0; // it is false so remove element
                        }
                    }
                    return false; // not able to fill any 1 to 9
                }
            }
        }
        return true;
	}

	static boolean isValid(int[][] board , int row , int col, int ch){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == ch)
                return false;
    
            if(board[row][i] == ch)
                return false;
        }
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for(int i = sr; i < sr + 3; i++){
            for(int j = sc; j < sc + 3; j++){
                if(board[i][j] == ch){
                    return false;
                }
            }
        }
        return true;
    }
}
