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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        ListNode swic = head.next;
        while(swic != null){
            ListNode nextNode = swic.next;
            swic.next = prev;
            prev = swic;
            swic = nextNode;
        }
        head.next = null;
        return prev;
    }
}