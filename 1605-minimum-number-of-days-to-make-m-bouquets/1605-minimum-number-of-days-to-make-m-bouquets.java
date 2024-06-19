class Solution {
    public boolean isPossible(int[] bloomDay,int daysToBloom, int m, int k){
        int bouquets = 0;
        int count = 0;
        int prevBloom = -1;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=daysToBloom && (prevBloom == -1 || prevBloom == i-1)){
                count++;
                prevBloom = i;
                if(count == k){
                    bouquets++;
                    count = 0;
                    prevBloom = -1;
                }
            }
            else {
                count = 0;
                prevBloom = -1;
            }
        }
        if(bouquets >= m) return true;
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int min = bloomDay[0];
        int max = bloomDay[0];
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int l = min;
        int r = max;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}