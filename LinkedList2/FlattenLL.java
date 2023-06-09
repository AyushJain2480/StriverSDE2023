// we are using recursion here but it will give TLE but this question is good in case if it comes in interview 
// you can explain this one first and than the optimised one.
public class Solution {
    public static Node flattenLinkedList(Node head) {
        if(head == null || head.next == null){
            return head;
        }
        head.next = flattenLinkedList(head.next);
        head = mergeTwoLists(head,head.next);
        return head;
    }
    
    static Node mergeTwoLists(Node a , Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a != null && b != null){
            if(a.data < b.data){
                temp.child = a;
                temp = temp.child;
                a = a.child;
            }else{
                temp.child = b;
                temp = temp.child;
                b = b.child;
            }
        }
        if(a != null) temp.child = a;
        else temp.child = b;
        return res.child;
    }
}


// WIthout recursion 
public static Node flattenLinkedList(Node head) {
        Node h1 = head;
        Node h2 = head.next;
        while(h2 != null){
          h1 = mergeTwoLists(h1, h2);
          h2 = h2.next;
        }
        return h1;
    }
