class Solution {
    long maxOr = 0;
    int count = 0;

    public void maxOrUtil(int index, int[] nums, long or){
        if(index == nums.length){
            if(or == maxOr){
                count++;
            }
            else if(or > maxOr){
                maxOr = or;
                count = 1;
            }
            return;
        }
        maxOrUtil(index+1,nums, or | nums[index]);
        maxOrUtil(index+1,nums, or);
    }

    public int countMaxOrSubsets(int[] nums) {
        maxOrUtil(0,nums,0);
        return count;        
    }
}