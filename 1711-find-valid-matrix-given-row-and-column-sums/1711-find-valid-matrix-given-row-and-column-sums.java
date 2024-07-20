class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        int[][] matrix = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int minValue = Math.min(rowSum[i],colSum[j]);
                matrix[i][j] = minValue;
                rowSum[i] = rowSum[i]-minValue;
                colSum[j] = colSum[j]-minValue;
            }
        }
        return matrix;
    }
}