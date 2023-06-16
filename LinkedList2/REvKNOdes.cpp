#include <bits/stdc++.h>

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/
Node *revK(Node *head, int k, int idx, int b[], int n)
{
    while (b[idx] == 0 and idx < n)
    {
        idx++;
    }
    k = b[idx];
    if (head == NULL || head->next == NULL)
        return head;
    if (idx == n)
        return head;

    Node *prev = NULL;
    Node *curr = head;
    Node *next;
    int count = 0;
    while (curr != NULL and count < k)
    {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
        count++;
    }

    if (curr != NULL)
    {
        head->next = revK(curr, b[idx + 1], idx + 1, b, n);
    }
    return prev;
}

Node *getListAfterReverseOperation(Node *head, int n, int b[])
{
    // Write your code here.
    Node *ans = revK(head, b[0], 0, b, n);
    return ans;
}
