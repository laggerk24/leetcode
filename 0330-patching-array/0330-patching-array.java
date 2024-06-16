class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        long miss = 1;
        while(miss<=n){
            if(i >= nums.length || miss<nums[i]){
                miss = miss+miss;
                count++;
            }
            else{
                miss = miss+nums[i];
                i++;
            } 
        }
        return count;
    }
}