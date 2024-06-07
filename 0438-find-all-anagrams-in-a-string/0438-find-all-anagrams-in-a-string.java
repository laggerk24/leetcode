class Solution {
    public boolean isArraysSame(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        int windowSize = p.length();
        for(int i=0;i<windowSize;i++){
            count[p.charAt(i)-'a']++;
        }
        int i=0;
        int[] freqOfWindow = new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int j=0;j<s.length();j++){
            freqOfWindow[s.charAt(j)-'a']++;
            while(j-i+1 > windowSize){
                freqOfWindow[s.charAt(i)-'a']--;
                i++;
            }
            if(j-i+1 == windowSize){
                if(isArraysSame(freqOfWindow,count)){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}