#include <bits/stdc++.h>
/****************************************************************

    Following is the class structure of the LinkedListNode class:

    template <typename T>
    class LinkedListNode
    {
    public:
        T data;
        LinkedListNode<T> *next;
        LinkedListNode(T data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/

LinkedListNode<int> *rev(LinkedListNode<int> *head)
{
    LinkedListNode<int> *prev = NULL;
    LinkedListNode<int> *curr = head;
    LinkedListNode<int> *next;
    while (curr != NULL)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}

bool isPalindrome(LinkedListNode<int> *head)
{
    // Write your code here.

    if (head == NULL || head->next == NULL)
        return true;

    LinkedListNode<int> *slow = head, *fast = head;
    while (fast->next != NULL and fast->next->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    slow->next = rev(slow->next);

    LinkedListNode<int> *temp = head;
    slow = slow->next;
    while (slow != NULL)
    {
        if (slow->data != temp->data)
        {
            return false;
        }
        slow = slow->next;
        temp = temp->next;
    }

    return true;
}
