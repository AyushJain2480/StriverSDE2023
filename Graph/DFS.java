// gfg
class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
           ArrayList<Integer> res = new ArrayList<>();
           boolean[] visited = new boolean[V];
           dfs(0,adj,visited, res);
           return res;
    }
    
    public void dfs(int sv, ArrayList<ArrayList<Integer>> adj, boolean[] visited,ArrayList<Integer> res){
        res.add(sv);
        visited[sv] = true;
        
        ArrayList<Integer> neighbors = adj.get(sv);
        for(Integer ele : neighbors){
            if(visited[ele] == false)
            dfs(ele,adj,visited,res);
        }
    }
}

// coding ninjas
import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        int[][] adj_matrix = new int[v][v];
        for(int i = 0; i < e; i++){
            ArrayList<Integer> edge = edges.get(i);
            int sv = edge.get(0);
            int ev = edge.get(1);
            adj_matrix[sv][ev] = 1;
            adj_matrix[ev][sv] = 1;
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        for(int i = 0; i < v; i++){
            if(visited[i] == false){
            ArrayList<Integer> l = new ArrayList<>();
            dfs(i,visited,adj_matrix, l);
            ans.add(l);
            }
        }
        return ans;
    }

    public static void dfs(int sv, boolean[] visited, int[][] adj_matrix,ArrayList<Integer> list){
       list.add(sv);
       visited[sv] = true;

       for(int i = 0; i < visited.length; i++){
           if(visited[i] == false && adj_matrix[sv][i] == 1){
              dfs(i,visited,adj_matrix,list);
           }
       }
    }
}
