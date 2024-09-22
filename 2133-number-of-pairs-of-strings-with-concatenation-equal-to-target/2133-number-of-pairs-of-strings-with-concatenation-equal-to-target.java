class Solution {
    public boolean stringMatcher(String s1, String s2){
        if(s1.length()!= s2.length()) return false;
        int pointer = 0;
        while(pointer<s1.length()){
            if(s1.charAt(pointer) != s2.charAt(pointer)) return false;
            pointer++;
        }
        return true;
    }
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                String conCated = nums[i]+nums[j];
                if(stringMatcher(conCated,target))
                    count++;
            }
        }
        return count;
    }
}