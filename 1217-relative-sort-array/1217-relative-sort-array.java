class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int index = 0;
        for(int i=0;i<arr2.length;i++){
            for(int j=0;j<arr1.length;j++){
                if(arr2[i] == arr1[j]){
                    int temp = arr1[j];
                    arr1[j] = arr1[index];
                    arr1[index++] = temp;
                }
            }
        }
        Arrays.sort(arr1,index,arr1.length);
        return arr1;
    }
}