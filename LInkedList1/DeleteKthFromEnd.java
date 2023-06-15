/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int n)
    {
        if(head == null) return null;
        if(head.next == null && n == 1){
            return null;
        }
    
        int N = findCount(head);
        if(N - n == 1){
            head = head.next;
            return head;
        }
        Node p = head;
        
        for(int i =1; i < N - n - 1; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    public static int findCount(Node head){
        Node curr = head;
        int count = 0;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count + 1;
    }
}
