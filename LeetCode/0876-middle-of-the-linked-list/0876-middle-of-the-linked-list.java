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
    public ListNode middleNode(ListNode head) {
        int length = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            length++;
        }
        //System.out.println("length: " + length);
        for(int i = 0; i < length/2; i++){
            //System.out.println(head.val);
            head = head.next;
        }

        return head;
    }
}
