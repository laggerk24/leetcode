class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] oneCount = new int[n];
        if(nums[0] == 1) oneCount[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i] == 1)
                oneCount[i] = oneCount[i-1] + 1;
            else oneCount[i] = oneCount[i-1];
        }
        int totalCount  = oneCount[n-1];
        if(totalCount == 0) return 0;
        if(totalCount == n) return 0;
        int minSwap = Integer.MAX_VALUE;
        int i = 0;
        for(int j=0;j<n;j++){
            while(j-i+1 > totalCount){
                i++;
            }
            if(j-i+1 == totalCount){
                if(i > 0)
                    minSwap = Math.min(minSwap,totalCount-(oneCount[j]-oneCount[i-1]));
                else 
                    minSwap = Math.min(minSwap,totalCount-(oneCount[j]));
            }
        }
        for(i=0;i<=totalCount;i++){
            int left = totalCount-1-i>0 ? oneCount[totalCount-1-i] : 0;
            int right = i>0 ? oneCount[n-1]-oneCount[n-i-1] : 0;
            minSwap = Math.min(minSwap,totalCount-(left+right));
        }    

        return minSwap;
    }
}