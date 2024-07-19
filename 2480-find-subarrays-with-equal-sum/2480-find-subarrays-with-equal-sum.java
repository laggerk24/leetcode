class Solution {
    public boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<=nums.length-2;i++){
            int sum = nums[i]+nums[i+1];
            if(set.contains(sum)) return true;
            set.add(sum);
        }
        return false;
    }
}