class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        int[] max = new int[n];
        Arrays.fill(max,Integer.MIN_VALUE);
        int minValue = nums[0];
        int maxValue = nums[n-1];
        for(int i=1;i<n;i++){
            minValue = Math.min(nums[i-1],minValue);
            min[i] = minValue;
        }
        for(int i=n-2;i>=0;i--){
            maxValue = Math.max(maxValue,nums[i+1]);
            max[i] = maxValue;
        }
        for(int i=1;i<n-1;i++){
            if(min[i]<nums[i] && nums[i]<max[i])
                return true;
        }
        return false;
    }
}