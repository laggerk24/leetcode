class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int length = 1;
                int currentNumber = num+1;
                while(set.contains(currentNumber)){
                    length++;
                    currentNumber++;
                }
                ans = Math.max(length,ans);
            }
        }
        return ans;
    }
}