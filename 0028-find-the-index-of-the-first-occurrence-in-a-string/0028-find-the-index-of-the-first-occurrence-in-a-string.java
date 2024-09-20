class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        for(int i=0;i<haystackArray.length;i++){
            if(stringCompare(i,haystackArray,needleArray))
                return i;
        }
        return -1;
    }
    public boolean stringCompare(int startIndex, char[] arr1, char[] arr2){
        int pointer = 0;
        while(startIndex<arr1.length && pointer < arr2.length  && arr1[startIndex] == arr2[pointer]){
            startIndex++;
            pointer++;
        }
        return pointer == arr2.length;
    }
}