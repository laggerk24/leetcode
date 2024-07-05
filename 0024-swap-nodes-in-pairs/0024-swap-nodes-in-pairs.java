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
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next == null ) return head;
        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode ans = head.next;
        while(currNode != null && currNode.next != null){
            ListNode rightMost= currNode.next.next;
            if(prevNode != null) prevNode.next = currNode.next;
            currNode.next.next = currNode;
            currNode.next = rightMost;
            prevNode = currNode;
            currNode = rightMost;
        }
        return ans;
    }
}