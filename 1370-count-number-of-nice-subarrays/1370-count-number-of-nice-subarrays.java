class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0;
        int ans =0;
        mpp.put(0,1);
        for(int i=0;i<n;i++){
            if(nums[i]%2==1){
                sum+=1;
            }
            int diff = sum-k;
            ans += mpp.getOrDefault(diff,0);
            mpp.put(sum,mpp.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
