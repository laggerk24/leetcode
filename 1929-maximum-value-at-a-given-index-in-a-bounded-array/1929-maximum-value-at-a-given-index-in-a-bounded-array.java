class Solution {
    public boolean isPossible(long element,int n, int maxSum, int index){
        long leftsum = 0;
        if(index >= element){
            leftsum = index-element+1;
            leftsum += (element)*(element+1)/2;
        }
        else{
            long sum1= (element)*(element+1)/2;
            long lastElement = element-index-1;
            long sum2 = (lastElement)*(lastElement+1)/2;
            leftsum = sum1-sum2;
        }
        long rightSum = 0;
        if(element<n-index){
            rightSum = n-index-element;
            rightSum += element*(element+1)/2;
        }
        else{
            long sum1= (element)*(element+1)/2;
            long lastElement = element-(n-index);
            long sum2 = (lastElement)*(lastElement+1)/2;
            rightSum = sum1-sum2;
        }
        long sum = leftsum+rightSum-element;
        if(sum>maxSum) return false;
        return true;
    }
    public int maxValue(int n, int index, int maxSum) {
        if(n==1) return maxSum;
        long l = 1;
        long r = (long)1e9;
        long ans = 0;
        while(l<=r){
            long mid = l+(r-l)/2;
            // System.out.println(l+" "+ mid + " "+ r);
            if(isPossible(mid,n,maxSum,index)){
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return (int)ans;
    }
}