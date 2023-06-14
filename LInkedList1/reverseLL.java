public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        LinkedListNode prev = null;
		LinkedListNode curr = head;
		LinkedListNode temp = null;
		while(curr != null){
            temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
    }
}
