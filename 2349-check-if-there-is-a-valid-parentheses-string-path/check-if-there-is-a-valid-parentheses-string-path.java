class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if((m+n-1)%2!=0){
            return false;
        }
        if(grid[0][0]==')' || grid[m-1][n-1]=='('){
            return false;
        }
        Boolean[][][] dp=new Boolean[m][n][m+n];

        return rec(grid,0,0,0,0,m,n,dp);
    }
    static boolean rec(char[][] arr,int i,int j,int o,int c,int m,int n,Boolean[][][] dp){
        if(i>=m || j>=n){
            return false;
        }
        if(arr[i][j]=='('){
            o++;
        }
        else{
            c++;
        }
        if(i==m-1 && j==n-1){
            if(o==c){
                return true;
            }
            return false;
        }
        if(c>o){
            return false;
        }
        if(dp[i][j][o-c]!=null){
            return dp[i][j][o-c];
        }
        return dp[i][j][o-c]=(rec(arr,i+1,j,o,c,m,n,dp)||rec(arr,i,j+1,o,c,m,n,dp));
    }
}