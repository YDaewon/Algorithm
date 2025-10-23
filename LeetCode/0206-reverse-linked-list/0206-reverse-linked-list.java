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
    ListNode res;
    ListNode pointer;
    public ListNode reverseList(ListNode head) {
        reverse(head);
        return pointer;
    }

    void reverse(ListNode cur){
        if(cur == null) return;
        if(cur.next == null){
            res = new ListNode(cur.val);
            pointer = res;
            return;
        }
        reverse(cur.next);
        res.next = new ListNode(cur.val);
        res = res.next;
        //System.out.println(cur.val);
    }
}