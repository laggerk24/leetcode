class Solution {
    public void rotate(int[][] mat){
        int n = mat.length;
        for(int l=1;l<=n;l++){
            for(int i=0;i<=(n-l);i++){
                int j = i+l-1;
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int l = 0;
            int r = n-1;
            while(l<r){
                int temp = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = temp;
                l++;
                r--;
            }
        }
    }

    public boolean check(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int count = 0;
        do{
            boolean flag = check(mat,target);
            if(flag) return true;
            rotate(mat);
            count++;
        }while(count<=4);    
        return false;
    }
}