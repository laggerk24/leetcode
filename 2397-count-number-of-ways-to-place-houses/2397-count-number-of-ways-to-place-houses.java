class Solution {
    public int mod = (int)1e9+7;
    public int countHousePlacements(int n) {
        // long way to do this question
        // 4 states possible
        //left present/absent, right present/absent
        //lets do it wiht 2 state first
        int[][] dp = new int[n][2];
        //0 - absent;
        //1 - present;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<n;i++){
            dp[i][1] = dp[i-1][0]%mod;
            dp[i][0] = dp[i-1][0]%mod+dp[i-1][1]%mod;
        }
        int totalWays = dp[n-1][0]%mod+dp[n-1][1]%mod;
        return (int)(((long)totalWays*totalWays)%mod);
    }
}