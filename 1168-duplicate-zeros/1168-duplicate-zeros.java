class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] copyArray = new int[n];
        int index = 0;
        boolean flag = true;
        for(int i=0;i<n;i++){
            if(arr[i] == 0 && flag){
                index = i;
                flag = false;
            } 
            copyArray[i] = arr[i];
        }
        index++;
        if(index<n && !flag) arr[index] = 0;
        int secondIndex = index;
        index++;
        while(index < n && secondIndex < n && !flag){
            if(copyArray[secondIndex] != 0){
                arr[index++] = copyArray[secondIndex++];
            }
            else if(copyArray[secondIndex] == 0){
                arr[index++] = copyArray[secondIndex++];
                if(index<n) arr[index++] = 0;
            }
        }
    }
}