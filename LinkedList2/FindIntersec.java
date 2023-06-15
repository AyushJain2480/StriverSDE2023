public class Solution {
    public static int findIntersection(Node h1, Node h2) {
      Node l1 = h1;
      Node l2 = h2;

      while(l1 != null || l2 != null){
         if(l1 == null) l1 = h2;
         if(l2 == null) l2 = h1;
         if(l1 == l2)  return l1.data;
         if(l1 != null){
           l1 = l1.next;
         }
         if(l2 != null){
            l2 = l2.next;
         } 
      }
      return -1;
    }
}
