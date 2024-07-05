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
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while( node!=null){
            size++;
            node = node.next;
        }
        int secondNodePos = size-k+1;
        node = head;
        ListNode firstNode = null;
        ListNode secondNode = null;
        for(int i=1;i<=size && node != null ;i++){
            if(i==k) firstNode = node;
            if(i == size-k+1) secondNode = node;
            if(firstNode != null && secondNode != null) break;
            node = node.next;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return head;
    }
}