class Solution {
    public int maxProduct(int[] nums) {                  
        int n = nums.length;         
        double prevMax = nums[0];         
        double prevMin = nums[0];         
        double ans = nums[0];         
        for(int i=1;i<n;i++){             
            double currMax = Math.max(prevMax*nums[i],Math.max(prevMin*nums[i],nums[i]));             
            double currMin = Math.min(prevMax*nums[i],Math.min(prevMin*nums[i],nums[i]));             
            ans = Math.max(currMax,ans);
            prevMax = currMax;
            prevMin = currMin;    
        }         
        return (int)ans;     
    }
}