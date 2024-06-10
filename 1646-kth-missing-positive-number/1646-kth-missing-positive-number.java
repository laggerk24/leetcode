class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k<arr[0]) return k;
        int n = arr.length;
        int lastMissingNo  = arr[n-1]-(n);
        if(lastMissingNo < k) return arr[n-1]+(k-lastMissingNo);
        int l = 0;
        int r = n-1;
        int index = 0;
        while(l<=r){
            int mid = (l+r)/2;
            int missingCount = arr[mid]-(1+mid);
            if(missingCount<k){
                index = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return k+(index+1);
    }
}