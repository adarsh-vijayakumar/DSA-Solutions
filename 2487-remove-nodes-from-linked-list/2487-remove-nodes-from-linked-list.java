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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        ListNode res = new ListNode(stack.pop().val);   // last node in given LL always stays

        while(!stack.isEmpty()){        // while iterating backwards
            cur = stack.pop();

            if(cur.val >= res.val){     // attach ONLY the higher valued nodes TO THE FRONT
                ListNode newNode = new ListNode(cur.val);
                newNode.next = res;
                res = newNode;          // i.e. FRONT of the LL always has the highest node so far
            }
        }
        return res;
    }
}
/**
TC: O(N)
SC: O(N)

sol 4m lc: Stack approach

 */