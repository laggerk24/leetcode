class Solution {
    public List<String> commonChars(String[] words) {
        int[] arr= new int[26];
        for(int i=0;i<words[0].length();i++){
            arr[words[0].charAt(i)-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] freq = new int[26];
            for(int k=0;k<words[i].length();k++){
                freq[words[i].charAt(k)-'a']++;
            }
            for(int l=0;l<26;l++){
                arr[l] = Math.min(arr[l],freq[l]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int l=0;l<26;l++){
            if(arr[l] > 0){
                Character ch = (char)(l+'a');
                for(int i=0;i<arr[l];i++){
                    ans.add(""+ch);
                }
            }
        }
        return ans;
    }
}