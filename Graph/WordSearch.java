class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j =0 ; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                   if(dfs(i,j,board,word,0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] board, String word, int k){
        if(k == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return false;
        }
        if(board[i][j] !=  word.charAt(k)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '*';
        
        boolean found = 
            dfs(i + 1,j,board,word,k + 1) ||
            dfs(i - 1,j,board,word,k + 1) || 
            dfs(i,j + 1,board,word,k + 1) ||
            dfs(i,j - 1,board,word,k + 1);
        
        board[i][j] = temp;
        return found;
    }
}
