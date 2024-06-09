class Solution {
    public int minOperations(int n) {
        int count = 0;
        while(n!=0){
            if((n&1) == 0){
                n = n>>1;
            }
            else{
                int secondBit = 2;
                if((n&secondBit) == 2){
                    n = n+1;
                }
                else n = n>>1;
                count++;
            }
        }
        return count;
    }
}