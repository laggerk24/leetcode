class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = arr[i];
            int count  = 1;
            int sum = 0;
            int ans = 0;
            for(int j=i;(j>=0 && j>= i-k+1);j--){
                max = Math.max(max,arr[j]);
                sum += arr[j];
                ans = j==0 ? Math.max(ans,max*count) : Math.max(ans, max*count+dp[j-1]);
                count++;
            }
            dp[i] = ans;
            // System.out.println(dp[i]);
        }
        return dp[n-1];
    }
}
