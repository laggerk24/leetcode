class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] xCount = new int[n][m];
        int[][] yCount = new int[n][m];
        if(grid[0][0] == 'X') xCount[0][0]++;
        if(grid[0][0] == 'Y') yCount[0][0]++;
        for(int i=1;i<n;i++){
            if(grid[i][0] == 'X')
                xCount[i][0]++;
            else if(grid[i][0] =='Y')
                yCount[i][0]++;
            xCount[i][0] = xCount[i][0]+xCount[i-1][0];
            yCount[i][0] = yCount[i][0]+yCount[i-1][0];
        }

        for(int j=1;j<m;j++){
            if(grid[0][j] == 'X')
                xCount[0][j]++;
            else if(grid[0][j] =='Y')
                yCount[0][j]++;
            xCount[0][j] = xCount[0][j]+xCount[0][j-1];
            yCount[0][j] = yCount[0][j]+yCount[0][j-1];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j] == 'X')
                    xCount[i][j]++;
                else if(grid[i][j] =='Y')
                    yCount[i][j]++;
                xCount[i][j] += xCount[i-1][j]+xCount[i][j-1]-xCount[i-1][j-1];
                yCount[i][j] += yCount[i-1][j]+yCount[i][j-1]-yCount[i-1][j-1];
            }   
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(xCount[i][j] > 0 && xCount[i][j] == yCount[i][j])
                    ans++;
            }   
        }
        return ans;
    }
}