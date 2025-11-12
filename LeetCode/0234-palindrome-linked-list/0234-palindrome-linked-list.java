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
    // public boolean isPalindrome(ListNode head) {
    //     Stack<Integer> s = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();
    //     int len = 0;

    //     ListNode temp = head;
    //     while(temp != null){
    //         s.add(temp.val);
    //         temp = temp.next;
    //         len++;
    //     }

    //     for(int i = 0; i < len/2; i++){
    //         s2.add(s.pop());
    //     }
    //     if(len % 2 == 1) s.pop();
    //     while(!s.isEmpty() && !s2.isEmpty()){
    //         if(s.pop() != s2.pop()) return false;
    //     }
    //     return true;

    // }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) slow = slow.next; // odd
        
        ListNode start = head;

        ListNode cur = slow;
        ListNode pre = null;

        while(cur != null){
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        while(pre != null){
            if(start.val != pre.val) return false;
            start = start.next;
            pre = pre.next;
        }

        return true;
    }
}