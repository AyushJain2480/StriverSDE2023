/**
 * Definition of linked list:
 *
 * class Node {
 * public:
 *      int data;
 *      Node *next;
 *      Node() {
 *          this->data = 0;
 *          this->next = NULL;
 *      }
 *      Node(int data) {
 *          this->data = data;
 *          this->next = NULL;
 *      }
 *      Node (int data, Node *next) {
 *          this->data = data;
 *          this->next = next;
 *      }
 * };
 *
 *************************************************************************/

Node *addTwoNumbers(Node *num1, Node *num2)
{
    // Write your code here.
    Node *ans = new Node();
    Node *res = ans;
    int carry = 0;
    while (num1 != NULL and num2 != NULL)
    {
        int sum = num1->data + num2->data + carry;
        carry = sum > 9;
        sum %= 10;
        ans->next = new Node(sum);
        ans = ans->next;
        num1 = num1->next;
        num2 = num2->next;
    }

    while (num1 != NULL)
    {
        int sum = num1->data + carry;
        carry = sum > 9;
        sum %= 10;
        ans->next = new Node(sum);
        ans = ans->next;
        num1 = num1->next;
    }
    while (num2 != NULL)
    {
        int sum = num2->data + carry;
        carry = sum > 9;
        sum %= 10;
        ans->next = new Node(sum);
        ans = ans->next;
        num2 = num2->next;
    }
    if (carry != 0)
        ans->next = new Node(carry);
    return res->next;
}
