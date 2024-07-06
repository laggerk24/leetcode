class Solution {
    public int passThePillow(int n, int time) {
        int totalPassInOneRound = 2*(n-1);
        int rem = time%totalPassInOneRound;
        if(rem <= n-1) return rem+1;
        else return n-(rem-(n-1));
    }
}