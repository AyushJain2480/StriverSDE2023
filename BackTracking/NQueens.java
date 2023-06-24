
// Leetcode 
import java.util.*;

class Solution {
    // thought process - I am trying to fill the column here
    void f(int col , int n , char[][] matrix, List<List<String>> res){
        if(col == n){
            res.add(construct(matrix));
            return;
        }
        for(int i = 0; i < n; i++){
            if(iCanFill(i, col, matrix)){
                matrix[i][col] = 'Q';
                f(col + 1, n, matrix,res);
                matrix[i][col] = '.';
            }
        }
       
    }
    List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    boolean iCanFill(int row, int col , char[][] board){
        int duprow = row;
        int dupcol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '.';
            }
        }     
        f(0, n , matrix, res);
        return res;
    }
}
