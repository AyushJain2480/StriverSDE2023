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
