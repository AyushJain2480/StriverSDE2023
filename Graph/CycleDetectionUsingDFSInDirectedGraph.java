// remeber for 0 to N if the node is marked like that than only this solution will  work if node is marked from 1 to N 
// you have to do some modification like for(int i = 0; i <= n; ) inc the size of boolean arrays by 1 and change the for loop below one with 1 to equal to n
import java.util.ArrayList;
public class Solution {
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());   
    }
    for(ArrayList<Integer> arr : edges){
       int sv = arr.get(0);
       int ev = arr.get(1);
       adj.get(sv).add(ev);
    }  
    return isCycle(adj, n);
  }

  private static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int v) {
          boolean[] helper = new boolean[v];
          boolean[] visited = new boolean[v];
          for(int i = 0; i < v; i++){
               if(!visited[i]){
                  if(dfs(adj,i,visited,helper)) // if any component has cycle it will return true
                      return true;
               }
          }
          return false; // if no component has cycle it will return false
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited, boolean[] helper){
         visited[i] = true;
         helper[i] = true;
         for(Integer neigh: adj.get(i)){
             if(helper[neigh]) return true;
             if(!visited[neigh]){
                 if(dfs(adj, neigh, visited, helper)) return true;
             }
         }
         // If all the neighbors of that element has been visited backtrack from there
         helper[i] = false;
         return false;
    } 
}
