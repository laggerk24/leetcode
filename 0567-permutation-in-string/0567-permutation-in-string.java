class Solution {
    public boolean isArraySame(int[] arr1, int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int windowSize = s1.length();
        for (int i = 0; i < windowSize; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        int i = 0;
        int[] windowFreq = new int[26];
        for (int j = 0; j < s2.length(); j++) {
            windowFreq[s2.charAt(j) - 'a']++;
            while (j - i + 1 > windowSize) {
                windowFreq[s2.charAt(i) - 'a']--;
                i++;
            }
            if (j - i + 1 == windowSize) {
                if(isArraySame(count,windowFreq))
                    return true;
            }
        }
        return false;
    }
}