/****************************************************************
 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
    
     Node()
     {
         this.data = 0;
         this.next = null;
     }
    
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
    
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {

    public static boolean detectCycle(Node head) {
        if(head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head.next;
        boolean flag = false;
        // if fast reaches null or fast.next = null means there is no cycle
        // if fast = slow means there is no null and there is cycle thats why 
        // fast move in that cycle and come back to slow
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
