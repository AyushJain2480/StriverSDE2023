class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<Integer>());
        }
        
        for(int[] arr : dislikes){
            int sv = arr[0];
            int ev = arr[1];
            list.get(sv).add(ev);
            list.get(ev).add(sv);
        }
        // suppose 1 dont like 2 and 3 so in 1 --> [2,3] while exploring 
        // the dislikes of 1 what we will do is just fill the different color
        // to the disliked persons than what 1 have so that they can be in 
        // different group
        for(int i = 1; i <= n; i++){
            if(color[i] == 1 || color[i] == -1) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            color[i] = 1;
            // curr and neigh are enemy so change their colors
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int neigh : list.get(curr)){
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
