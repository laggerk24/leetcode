class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int firstCol = 0;
        int lastCol = grid[0].length-1;
        int firstRow = 0;
        int lastRow = grid.length-1;
        while(firstCol<lastCol && firstRow<lastRow){
            int length = 2*(lastRow-firstRow)+2*(lastCol-firstCol);
            int rotations = k%length;  // I was doing the division incorrect
            while(rotations>0){
                // System.out.println(firstRow+" "+lastRow+" "+firstCol+" "+lastCol);
                int temp = grid[firstRow][firstCol];
                for(int j=firstCol;j<lastCol;j++){
                    grid[firstRow][j] = grid[firstRow][j+1];
                }
                for(int i=firstRow;i<lastRow;i++){
                    grid[i][lastCol] = grid[i+1][lastCol];
                }
                for(int j=lastCol;j>firstCol;j--){
                    grid[lastRow][j] = grid[lastRow][j-1];
                }
                for(int i=lastRow;i>firstRow;i--){
                    grid[i][firstCol] = grid[i-1][firstCol];
                }
                grid[firstRow+1][firstCol] = temp;
                rotations--;
            }
            firstRow++;
            firstCol++;
            lastRow--;
            lastCol--;
        }
        return grid;
    }
}