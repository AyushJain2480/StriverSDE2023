class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        int total = 0, time = 0, rotten = 0;
        
        // add all the rotten oranges in the queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                if(grid[i][j] == 2) queue.offer(new Pair(i,j));
            }
        }
        
        if(total == 0) return 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            rotten += size;
            if(rotten == total) return time; // all the oranges are rotted return minutes
            
            time++;
            
            for(int i = 0; i < size; i++){ // for all the rotten present in queue
                // find the fresh oranges in neighbour make them rotted add them in queue inc min like that we can solve
                Pair p = queue.peek();
                
                if(p.x - 1 >= 0 && grid[p.x - 1][p.y] == 1){
                    grid[p.x - 1][p.y] = 2; // make it rottted and add in queue
                    queue.offer(new Pair(p.x - 1,p.y));
                }
                if(p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1){
                    grid[p.x + 1][p.y] = 2;
                    queue.offer(new Pair(p.x + 1,p.y));
                }
                if(p.y - 1 >= 0 && grid[p.x][p.y - 1] == 1){
                    grid[p.x][p.y - 1] = 2;
                    queue.offer(new Pair(p.x,p.y - 1));
                }
                if(p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1){
                    grid[p.x][p.y + 1] = 2;
                    queue.offer(new Pair(p.x,p.y + 1));
                }
                queue.poll();
            }
        } 
        return -1;
    }
}
