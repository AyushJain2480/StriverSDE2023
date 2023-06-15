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


// recursive solution O(m + n)
class Solution{ 
public ListNode mergeTwoLists(ListNode l1 , ListNode l2){
    // base case 
    // obv if 1 list is null we have to return the second list 
    if(l1 == null){
        return l2;
    }
    if(l2 == null){
        return l1;
    }
    if(l1.val < l2.val){
        // becoz we want sorted list so we will select the smaller one
        // Have faith that this function will give me a sorted list for further elements
        l1.next = mergeTwoLists(l1.next,l2);
        return l1;
    }
        // means l2 is smaller
        // same have faith in recursion that it will return the sorted list for further elements
        l2.next = mergeTwoLists(l1,l2.next);
        return l2;
}
}
