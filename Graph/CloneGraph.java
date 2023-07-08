/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
     if(node == null) return null;
     
     Map<Node,Node> map = new HashMap<>(); // org|clone
        
     Queue<Node> queue = new ArrayDeque<>();
     
     // add first node   
     queue.add(node);
     
     // create the clone of that first node in map   
     map.put(node, new Node(node.val, new ArrayList<>()));
        
     while(!queue.isEmpty()){
         
         Node h = queue.poll(); // explore all its neighbours and create its corresponding 
         // key value pairs
         
         for(Node neighbour : h.neighbors){
             if(!map.containsKey(neighbour)){
                 map.put(neighbour, new Node(neighbour.val,new ArrayList<>()));
                 queue.add(neighbour);
             }
             map.get(h).neighbors.add(map.get(neighbour));
         }
    
     }  
     return map.get(node);   
   }
}
