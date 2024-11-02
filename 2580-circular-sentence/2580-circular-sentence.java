class Solution {
    public boolean isCircularSentence(String s) {
        if(s.charAt(0) != s.charAt(s.length()-1)) return false;
        String [] arr = s.split(" ");
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i].charAt(arr[i].length()-1) != arr[j].charAt(0)) return false;
            i++;
        }
        return true;
    }
}