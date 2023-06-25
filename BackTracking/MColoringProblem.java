import java.util.* ;
import java.io.*; 
public class Solution {

	static boolean isSafe(int node,int[][] G, int m, int n , int[] color , int col){
    for(int k=0;k<n;k++){
        if(k!=node && G[node][k]==1 && color[k]==col){
            return false;
        }
    }
    return true;
    }
    
    static boolean solve(int node, int[][] G,int m, int n, int[] color){
        if(node == n) return true;
        for(int i = 1; i <= m; i++){
            if(isSafe(node,G,m,n,color,i)){ // if adj node is not having the same color as i do that clr
                color[node] = i;
				// if we are able to color all the n node with m color 
				// from node + 1 we will directly return true from there 
				// no need to check for further 
                if(solve(node+1, G, m, n, color)) return true;
                color[node] = 0; // backtrack
            }
        }
		// tried every color from 1 to m but not able to color 
		return false;
    }

	public static String graphColoring(int[][] G, int m) {
		int n = G.length;
		int[] color = new int[n];
        if(solve(0,G,m,n,color)) return "YES";
        return "NO";
	}
}
