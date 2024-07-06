class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int l=1;l<=n;l++){
            for(int i=0;i<=(n-l);i++){
                int j = i+l-1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int j = 0;
            int l = n-1;
            while(j<l){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l];
                matrix[i][l] = temp;
                j++;
                l--;
            }
        }
    }
}