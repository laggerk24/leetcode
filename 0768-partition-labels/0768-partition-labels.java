class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] rightMost = new int[26];
        Arrays.fill(rightMost,-1);
        char[] arr = s.toCharArray();
        int r = arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(rightMost[arr[r]-'a'] == -1) rightMost[arr[r]-'a'] = r;
            r--;
        }
        List<Integer> ans = new ArrayList<>();
        int leftPos = 0;
        int rightPos = 0;
        for(int i=0;i<arr.length;i++){
            if(rightMost[arr[i]-'a'] > rightPos){
                rightPos = rightMost[arr[i]-'a'];
            }
            if(i == rightPos){
                ans.add(rightPos-leftPos+1);
                rightPos = i+1;
                leftPos = i+1;
            }
        }
        return ans;
    }
}