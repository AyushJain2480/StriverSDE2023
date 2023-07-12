// 1 -> blue , -1 -> red, 0 - uncolored
// graph coloring
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i = 0; i < n; i++){
            // already coloured means it is a part of any component
            // so no need to create a new queue we will create it 
            // for new component
            if(color[i] == -1 || color[i] == 1) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            
            // simple find its neighbours color them with alternate colors 
            // if any time you found two adjacent nodes with same color return false
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int neigh : graph[curr]){
                    if(color[neigh] == 0){
                        color[neigh] = -color[curr];
                        queue.add(neigh);
                    }
                    if(color[neigh] == color[curr]) return false;
                }
            }
        }
        return true;
    }
}
