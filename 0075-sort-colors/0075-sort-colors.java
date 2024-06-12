class Solution {
    public void sortColors(int[] nums) {
        int index = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                nums[i] = nums[index];
                nums[index] = 0;
                index++;
            }
        }
        for(int i=index;i<n;i++){
            if(nums[i] == 1){
                nums[i] = nums[index];
                nums[index] = 1;
                index++;
            }
        }
    }
}