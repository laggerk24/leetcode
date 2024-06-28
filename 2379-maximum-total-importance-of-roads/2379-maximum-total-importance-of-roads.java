class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for(int[] road:roads){
            freq[road[0]]++;
            freq[road[1]]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++){
            pq.offer(new int[]{i,freq[i]});
        }
        int count = n;
        while(!pq.isEmpty()){
            int[] road = pq.poll();
            freq[road[0]] = count;
            count--;
        }
        long ans = 0;
        for(int[] road:roads){
            ans = ans + freq[road[0]]+freq[road[1]];
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(i+" - "+freq[i]);
        // }
        return ans;
    }
}