// gfg
class Solution {
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
