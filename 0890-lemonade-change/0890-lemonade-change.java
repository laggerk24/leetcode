class Solution {
    public boolean lemonadeChange(int[] bills) {
        int x5 = 0;
        int x10 = 0;
        int x20 = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                x5++;
            }
            else if(bills[i] == 10){
                x5--;
                x10++;
                if(x5<0) return false;
            }
            else if(bills[i] == 20){
                if(x10>0){
                    x10--;
                    if(x5<=0) return false;
                    x5--;
                    x20++;
                }
                else{
                    x5 = x5-3;
                    if(x5<0) return false;
                    x20++;
                }
            }
        }
        return true;
    }
}