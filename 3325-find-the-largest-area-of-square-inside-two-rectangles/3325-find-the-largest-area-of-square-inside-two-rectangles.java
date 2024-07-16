class Solution {
    // y coordinates - 1
    // x coordinates - 0
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(topRight[i][0]>bottomLeft[j][0] && topRight[j][0]>bottomLeft[i][0] 
                && topRight[j][1]>bottomLeft[i][1] && bottomLeft[j][1]<topRight[i][1]){
                    int commonLength = Math.min(topRight[i][0],topRight[j][0])-Math.max(bottomLeft[i][0],bottomLeft[j][0]);
                    int commonHeight = Math.min(topRight[i][1],topRight[j][1])-Math.max(bottomLeft[i][1],bottomLeft[j][1]);
                    long side = Math.min(commonLength,commonHeight);
                    maxSide = Math.max(maxSide,side);
                }
            }
        }
        return maxSide*maxSide;
    }
}