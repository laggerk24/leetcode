class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int l=1;l<=n;l++){
            for(int i=0;i<=n-l;i++){
                int j = i+l-1;
                if(i == j){
                    dp[i][j] = 1;
                    ans++;
                }
                else if(arr[i] == arr[j] && (i+1==j || dp[i+1][j-1] == 1)){
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans;
    }
}