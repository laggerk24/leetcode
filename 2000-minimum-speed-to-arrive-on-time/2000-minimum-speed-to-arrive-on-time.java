class Solution {
    public boolean isPossible(int speed,int[] dist, double hour){
        double time = 0;
        for(int i=0;i<dist.length;i++){
            double t  = dist[i]*1.0/speed; // need to multiply with 1.0 not sure why
            if(i != dist.length-1){
                time += Math.ceil(t);
            }
            else time += t;
            if(time > hour) return false;
        }
        return true;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = (int)1e9;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(isPossible(mid,dist,hour)){
                ans= mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}