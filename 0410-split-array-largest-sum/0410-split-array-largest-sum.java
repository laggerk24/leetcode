class Solution {
    public boolean isPossible(int maxSum, int [] nums, int k){
        int countSubset = 1;
        int subSetSum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>maxSum) return false;
            if(subSetSum + nums[i] <= maxSum){
                subSetSum += nums[i];
            }
            else{
                countSubset ++;
                subSetSum = nums[i];
            }
            if(countSubset > k) return false;
        }
        return true;
    }
    public int splitArray(int[] nums, int k) {
        int l = 1;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        int r = sum;
        int ans = 0;
        while(l<=r){
            int mid = l + (r-l)/2;
            // System.out.println(l+ " - "+ mid + " -  " + r);
            if(isPossible(mid,nums,k)){
                ans = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}