class Solution {
    public boolean isAnagram(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        ans.add(words[i]);
        for(int j=1;j<words.length;j++){
            if(!isAnagram(words[i],words[j])){
                ans.add(words[j]);
                i = j;
            }
        }
        return ans;
    }
}