class Solution {
    public int snakesAndLadders(int[][] board){
        int n = board.length;
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(1); // starting from 1 
        visited[n - 1][0] = true; // mark it visited
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i < size; i++){
                int x = queue.poll();
                if(x == n * n) return steps;
                
                for(int k = 1; k <= 6; k++){// dice rolling from 1 to 6
                    // x + 1 , x + 2, x + 3, x + 4, x + 5, x + 6 these are possible
                    // future positions
                    if(k + x > n * n) break; // if it cross the final pos break it
                    
                    int[] pos = findCoordinates(k + x, n);
                    
                    int r = pos[0];
                    int c = pos[1];
                    
                    if(visited[r][c] == true) continue;
                    
                    visited[r][c] = true;
                    
                    if(board[r][c] == -1){ // there is no snake or ladder
                        queue.add(k + x);
                    }else{
                        queue.add(board[r][c]); // there is a snake or ladder so 
                        // fill the position whatever is in the board.
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    
    public int[] findCoordinates(int curr, int n){
        int r = n - (curr - 1) / n -1;
        int c = (curr - 1) % n;
        if(r % 2 == n % 2){
            return new int[]{r,n - 1 - c};
        }else{
            return new int[]{r,c};
        }
    }
}
