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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prevNode = head;
        ListNode currNode = head.next;
        ListNode nextNode = head.next.next;
        int[] ans = new int[] {Integer.MAX_VALUE,Integer.MIN_VALUE};
        int count = 0;
        int prevCriticalPoint = -1;
        int firstCriticalPoint = -1;
        while(nextNode != null){
            if((currNode.val > prevNode.val && currNode.val> nextNode.val) || (currNode.val < prevNode.val && currNode.val<nextNode.val)){
                if(prevCriticalPoint == -1){
                    prevCriticalPoint = count;
                    firstCriticalPoint = count;
                }
                else {
                    ans[0] = Math.min(ans[0],count-prevCriticalPoint);
                    ans[1] = Math.max(ans[1],count-firstCriticalPoint);
                }
                prevCriticalPoint = count;
            }
            prevNode = prevNode.next;
            currNode = currNode.next;
            nextNode = nextNode.next;
            count++;
        }
        return ans[0] == Integer.MAX_VALUE ? new int[]{-1,-1} : ans ;
    }
}