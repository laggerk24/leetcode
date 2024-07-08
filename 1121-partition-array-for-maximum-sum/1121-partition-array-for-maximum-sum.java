class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int val = 0;
            int max = arr[i];
            int count = 1;
            for(int j=i;(j>=0 && j>= i-k+1);j--){
                max = Math.max(max,arr[j]);
                val = j!=0 ? Math.max(val,count*max+dp[j-1]): Math.max(val,max*count);
                count++;
            }
            dp[i] = val;
        }
        return dp[n-1];
    }
}