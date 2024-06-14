class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= nums[i-1]){
                count = count + Math.abs(nums[i]-nums[i-1])+1;
                nums[i] = nums[i-1]+1;
            }
        }
        return count;
    }
}