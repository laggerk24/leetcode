class Solution {
    public boolean judgeSquareSum(int c) {
        long root = 0;
        long l = 1;
        long r = c;
        while(l<=r){
            long mid = l+(r-l)/2;
            long prod = mid*mid;
            if(prod == c) return true;
            if(prod > c){
                r = mid-1;
            }
            else {
                root = mid;
                l = mid+1;
            }
        }
        l = 0;
        r = root;
        while(l<=r){
            long prod = l*l+r*r;
            if(prod == c) return true;
            if(prod > c){
                r--;
            }
            else l++;
        }
        return false;
    }
}