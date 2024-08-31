class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;
        int evenCount = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 1){
                sum += 1;
            }
            int diff = sum-k;
            ans += map.getOrDefault(diff,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}