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
    public ListNode mergeNodes(ListNode head) {
        ListNode newHead = new ListNode();
        ListNode prevNode = newHead;
        head = head.next;
        int sum = 0;
        while(head != null){
            if(head.val != 0){
                sum = sum+head.val;
            }
            else if(head.val == 0){
                prevNode.val = sum;
                sum = 0;
                if(head.next != null){
                    prevNode.next = new ListNode();
                }
                prevNode = prevNode.next;
            }
            head = head.next;
        }
        return newHead;
    }
}