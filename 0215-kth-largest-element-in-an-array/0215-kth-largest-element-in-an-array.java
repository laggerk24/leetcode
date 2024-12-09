class Solution {
    PriorityQueue<Integer> pq;
    public int findKthLargest(int[] nums, int k) {
        pq = new PriorityQueue<>();
        for(int num:nums){
            add(num,k);
        }

        return pq.peek();
    }

    private int add(int val, int k) {
        if(pq.size() < k){
            pq.add(val);
        } 
        else if(pq.peek() < val){
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}