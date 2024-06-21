class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalCustomer = 0;
        int n = customers.length;
        for(int i=0;i<n;i++){
            if(grumpy[i] == 0 || minutes>= n){
                totalCustomer += customers[i];
            }
        }
        int i = 0;
        int ans = totalCustomer;
        if(minutes>=n) return totalCustomer;
        for(int j=0;j<n;j++){
            if(grumpy[j] == 1){
                totalCustomer += customers[j];
            }
            while(j-i+1>minutes){
                if(grumpy[i] == 1){
                    totalCustomer = totalCustomer - customers[i];
                }
                i++;
            }
            ans = Math.max(ans,totalCustomer);
        }
        return ans;
    }
}