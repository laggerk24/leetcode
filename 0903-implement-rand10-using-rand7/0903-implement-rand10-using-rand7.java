/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    private int prev = 0;
    public int rand10() {
        int num = rand7();
        if(num+prev>10){
            
            return prev = num+prev-10;
        }
        return prev = num+prev;
    }
}