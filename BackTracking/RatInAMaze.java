// m is the given matrix and n is the order of matrix
class Solution {
    
    public static void solve(int i, int j, int[][] m, int n, int[][] vis ,int[] di, int[] dj, ArrayList<String> ans, String str){
        if(i == n - 1 && j == n - 1){
            ans.add(str);
            return;
        }
        
        String dir = "DLRU";
        for(int ind = 0; ind < 4; ind++){
            int nexti = i + di[ind];
            int nextj = j + dj[ind];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && m[nexti][nextj] == 1){
               vis[i][j] = 1;
               solve(nexti,nextj,m,n,vis,di,dj,ans,str + dir.charAt(ind));
               vis[i][j] = 0;
            }
        }
    }
    
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        int[][] vis = new int[n][n];
        // lexico - DLRU
        int[] di = {1,0,0,-1};
        int[] dj = {0,-1,1,0};
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) solve(0,0,m,n,vis,di,dj,ans,"");
        return ans;
    }
}



import java.util.ArrayList;

public class Solution {
    private static final int[] di = {1, 0, 0, -1}; // Down, Right, Left, Up
    private static final int[] dj = {0, 1, -1, 0};

    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (maze[0][0] == 0) {
            return list;
        }
        int[][] path = new int[n][n];
        allPath(maze, n, path, list, 0, 0);
        return list;
    }

    private static void allPath(int[][] maze, int n, int[][] path, ArrayList<ArrayList<Integer>> list, int row, int col) {
        path[row][col] = 1;
        if (row == n - 1 && col == n - 1) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    ans.add(path[i][j]);
                }
            }
            list.add(ans);
            path[row][col] = 0;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nextRow = row + di[d];
            int nextCol = col + dj[d];
            if (pathIsPossible(nextRow, nextCol, maze, path)) {
                allPath(maze, n, path, list, nextRow, nextCol);
            }
        }

        path[row][col] = 0;
    }

    private static boolean pathIsPossible(int row, int col, int[][] maze, int[][] path) {
        int n = maze.length;
        return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && path[row][col] == 0;
    }
}

