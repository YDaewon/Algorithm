/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        while(head.next != null){
            if(head.val == -999999) return true; 
            head.val = -999999;
            head = head.next;
        }
        return false;
    }
}