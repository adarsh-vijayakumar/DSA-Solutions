/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = l1, num2 = l2;
        ListNode dummy = new ListNode(99);
        ListNode res = dummy;
        int carry = 0;                             // maintain a separate carry
        while(num1 != null || num2 != null){
            int added = carry;                    // add prev carry
            if(num1 != null){
                added += num1.val;                // + num1.val
                num1 = num1.next;
            }
            if(num2 != null){
                added += num2.val;               // + num2.val
                num2 = num2.next;
            }
            ListNode temp = new ListNode(added % 10);         // create a new node with val of unit's place digit
            carry = added / 10;                             // take the ten's place digit as carry
            res.next = temp;                       // res was standing at last node of new list. Link res to new node
            res = res.next;                        // move res: pointing it to the last node
        }
        if(carry > 0){
            ListNode temp = new ListNode(carry);
            res.next = temp;
        }  
        return dummy.next;
    }
}
/**

TC: O(max(n1, n2))
SC: O(1) \ excluding o/p LL

 */