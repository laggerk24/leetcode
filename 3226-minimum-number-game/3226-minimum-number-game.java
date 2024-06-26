class Solution {
    public int[] numberGame(int[] nums) {
        int[] map = new int[101];
        int n = nums.length;
        int[] ans = new int[n];
        int index= 0;
        int num1 = -1;
        for(int i=0;i<n;i++){
            map[nums[i]]++;
        }
        for(int i=0;i<=100;i++){
            if(map[i] > 0){
                if(num1 == -1){
                    num1 = i;
                }
                else if(num1 != -1){
                    ans[index++] = i;
                    ans[index++] = num1;
                    num1 = -1;
                }
                map[i]--;
                if(map[i]>0){
                    i--;
                }
            }
        }
        return ans;
    }
}