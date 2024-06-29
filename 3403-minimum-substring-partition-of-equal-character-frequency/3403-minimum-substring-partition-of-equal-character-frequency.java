class Solution {
    public boolean isFreqSame(int[] freq){
        int lastFreq = -1;
        for(int i=0;i<26;i++){
            if(freq[i] != 0 && lastFreq == -1)
                lastFreq = freq[i];
            else if(freq[i] != 0 && freq[i] != lastFreq)
                return false;
        }
        return true;
    }

    public int minimumSubstringsInPartition(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1100);
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j>=0;j--){
                freq[arr[j]-'a']++;
                if(isFreqSame(freq)){
                    dp[i] = j == 0 ? 1:Math.min(dp[i],1+dp[j-1]);
                }
            }
        }
        return dp[n-1] == 1001? 0: dp[n-1];
    }
}