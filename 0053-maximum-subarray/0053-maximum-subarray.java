class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        if(nums.length == 1)
            return nums[0];
        for(int i=1;i<nums.length;i++){
            if(sum<0 && nums[i] > 0)
                sum = 0;
            if(sum+nums[i] > 0){
                sum = sum+nums[i];
            }
            else sum = nums[i];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
}