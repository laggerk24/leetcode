class Solution {
    public double largestSumOfAverages(int[] nums, int p) {
        int n = nums.length;
        // dp[i][j] -- > max answer of question till index i with j partitions.
        double[][] dp = new double[n][p + 1];
        for (double[] arr : dp) {
            Arrays.fill(arr, -1e9);
        }
        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += nums[i];
            dp[i][1] = (arraySum) / (i + 1);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= p; j++) {
                double sum = 0;
                int count = 1;
                double val = -1;
                for (int k = i; k >= 0; k--) {
                    sum += nums[k];
                    double avg = (sum) / count;
                    val = k == 0 ? Math.max(val, avg) : Math.max(val, avg + dp[k - 1][j - 1]);
                    count++;
                }
                dp[i][j] = val;
            }
        }
        double ans = 0;
        for (int j = 1; j <= p; j++) {
            ans = Math.max(ans, dp[n - 1][j]);
        }
        return ans;
    }
}