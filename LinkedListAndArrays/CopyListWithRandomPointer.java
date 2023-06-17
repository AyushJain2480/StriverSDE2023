import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	public static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		 HashMap<LinkedListNode,LinkedListNode> map = new HashMap<>();
        
       LinkedListNode curr = head;
    
       LinkedListNode newHead = new LinkedListNode(-1);
       LinkedListNode prev = newHead;
       
       while(curr != null){
           LinkedListNode node = new LinkedListNode(curr.data);
           map.put(curr,node);
           prev.next = node;
           prev = prev.next;
           curr = curr.next;
       } 
        
       newHead = newHead.next;
       LinkedListNode c1 = head;
       LinkedListNode c2 = newHead;
        
       while(c1 != null){
          c2.random = (c1.random != null ) ? map.get(c1.random) : null;
          c1 = c1.next;
          c2 = c2.next;
       } 
       return newHead; 
	}
}
