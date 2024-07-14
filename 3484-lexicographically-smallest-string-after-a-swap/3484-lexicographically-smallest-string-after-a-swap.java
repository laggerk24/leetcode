class Solution {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for(int i=1;i<arr.length;i++){
            int num1 = arr[i]-'0';
            int num2 = arr[i-1]-'0';
            if(((num1 % 2 == 0 && num2 % 2 == 0) || (num1 % 2 == 1 && num2 % 2 == 1) ) && num1 < num2){
                char temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                break;
            }
        }
        return new String(arr);
    }
}