class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                boolean flag = true;
                if (points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) {
                    for (int k = 0; k < n; k++) {
                        if (k != j && k != i) {
                            if(points[i][0]<=points[k][0] && points[k][0]<=points[j][0] && points[i][1]>=points[k][1] && points[k][1]>= points[j][1]){
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(flag) count++;
                }
            }
        }
        return count;
    }
}