class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public int findTheWinner(int n, int k) {
        ListNode firstNode = new ListNode(1);
        ListNode prev = firstNode;
        for(int i=2;i<=n;i++){
            ListNode node = new ListNode(i);
            prev.next = node;
            prev = node;
        }
        prev.next= firstNode;
        int count = 0;
        ListNode node = firstNode;
        while(node.next != node){
            for(int i=1;i<k;i++){
                prev = node;
                node = node.next;
            }
            prev.next = node.next;
            node = node.next;
        }
        return node.val;
    }
}