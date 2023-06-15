// better approach but honestly not that intuitive 
public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> list1, LinkedListNode<Integer> list2) {
		LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode<Integer> t1 = list1;
        LinkedListNode<Integer> t2 = list2;
        LinkedListNode<Integer> temp = dummy;
        
        while(t1 != null && t2 != null){
            if(t1.data <= t2.data){
                temp.next = t1;
                t1 = t1.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 != null){
            temp.next = t1;
        }
        if(t2 != null){
            temp.next = t2;
        }
        return dummy.next;
	}
}


// using space and sorting 

 public ListNode mergeTwoLists(ListNode list1 , ListNode list2){
        ArrayList<Integer> list = new ArrayList<>();
        while(list1 != null){
            list.add(list1.val);
            list1 = list1.next;
        }

        while(list2 != null){
            list.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(list);

       ListNode dummy = new ListNode(0);
       ListNode temp = dummy;
       for(Integer i : list){
           ListNode newNode = new ListNode();
           newNode.val = i;
           temp.next = newNode;
           temp = temp.next;
       }
       return dummy.next;
    }
