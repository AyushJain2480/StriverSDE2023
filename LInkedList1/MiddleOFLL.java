public class Solution
{
    public static Node findMiddle(Node head)
    {   
        if(head == null){
            return null;
        }
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
