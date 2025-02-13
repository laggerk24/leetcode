class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        int i = 0;
        for(int j=0;j<nums.length;j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(j-i+1> k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }
            if(j-i+1 == k){
                ans[index] = map.lastKey();
                index++;
            }
        }
        return ans;
    }
}