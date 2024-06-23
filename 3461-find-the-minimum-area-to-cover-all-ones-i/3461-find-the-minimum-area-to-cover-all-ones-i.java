class Solution {
    public int minimumArea(int[][] grid) {
        TreeSet<Integer> rows = new TreeSet<>();
        TreeSet<Integer> cols = new TreeSet<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        // if(rows.size() == 1 && cols.size() == 1){
        //     return 1;
        // }
        
        int firstRow = rows.first();
        int lastRow = rows.last();
        int firstCol = cols.first();
        int lastCol = cols.last();
        
        // if(rows.size() == 1 && cols.size() > 1){
        //     return lastCol-firstCol+1;
        // }
        return (lastRow-firstRow+1)*(lastCol-firstCol+1);
    }
}