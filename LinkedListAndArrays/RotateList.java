// Brute force selecting from the last and setting to the front side
// TC - O(k * N) N times find the last node and i.e we are doing upto k tiems 
// SC - O(1)
public class Solution {
    public static Node rotate(Node head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int count = 1;
        Node tail = head;
        Node prev = head;
        Node front = null;
        
        while(tail.next != null){
            count++;
            tail = tail.next;
        }
        
        k = k % count;
        
        while(k-- > 0){
            prev = head;
            while(prev.next != tail){
                prev = prev.next;
            }
            tail.next = head;
            front = tail;
            tail = prev;
            prev.next = null;
            head = front;
        }
        return head;
    }
}

// Optimised solution 


