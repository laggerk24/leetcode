class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        int ans = 0;
        boolean oddFound = false;
        for(int i=0;i<256;i++){
            if(freq[i]%2 == 0){
                ans += freq[i];
            }
            else {
                if(!oddFound){
                    ans += freq[i];
                    oddFound = true;
                }
                else ans += (freq[i]-1);
            }
        }
        return ans;
    }
}