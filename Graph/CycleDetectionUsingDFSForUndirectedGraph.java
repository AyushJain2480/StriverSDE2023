import java.util.ArrayList;

public class Solution {
    
    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
           adj.add(new ArrayList<Integer>());
        }
        for(int[] arr : edges){
            int sv = arr[0];
            int ev = arr[1];
            adj.get(sv).add(ev);
            adj.get(ev).add(sv);
        }
        return (isCycle(adj, n) == true) ? "Yes": "No";
    }

    public static boolean dfs(int sv, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent){
        visited[sv] = true;
        for(Integer v : adj.get(sv)){
            if(!visited[v]){
               if(dfs(v, adj, visited, sv))
                   return true;
            }else if(parent != v){
                return true;
            }
        }
        return false;
    }
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v){
        boolean[] visited = new boolean[v + 1];
        for(int i = 1; i <= v; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited, -1))
                    return true; // if any component has cycle return true;
            }
        }
        return false; // if there is no cycle in any component return false
    }
    
}
