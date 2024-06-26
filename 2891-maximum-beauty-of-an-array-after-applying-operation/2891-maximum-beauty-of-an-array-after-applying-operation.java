class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        if(min == max) return nums.length;

        int[] map = new int[max+k+4];
        for(int i=0;i<nums.length;i++){
            if(nums[i]-k >=0)
                map[nums[i]-k] = map[nums[i]-k]+1;
            else 
                map[0] = map[0]+1;
            map[nums[i]+k+1] = map[nums[i]+k+1]-1;
        }
        int maxOccurance = map[0];
        for(int i=1;i<=max+k;i++){
            map[i] = map[i]+map[i-1];
            maxOccurance = Math.max(maxOccurance,map[i]);
        }
        return maxOccurance;
    }
}