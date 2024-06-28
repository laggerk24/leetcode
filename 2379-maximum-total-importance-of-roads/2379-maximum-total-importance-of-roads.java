class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for(int[] road:roads){
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);
        long ans = 0;
        long count = 1;
        for(int i=0;i<n;i++){
            ans += (freq[i]*count);
            count++;
        }
        return ans;
    }
}