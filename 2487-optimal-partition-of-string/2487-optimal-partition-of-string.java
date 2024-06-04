class Solution {
    public int partitionString(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        int count = 1;
        for(int j=0;j<arr.length;j++){
            if(freq[arr[j]-'a'] > 0){
                count++;
                Arrays.fill(freq,0);
            }
            freq[arr[j]-'a']++;
        }
        return count;
    }
}