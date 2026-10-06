class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int i = obstacleGrid.length ;
        int j = obstacleGrid[0].length ;
        int[][] dp = new int[i][j];
        for(int x = 0;x<i;x++){
            for(int y = 0;y<j;y++){
                dp[x][y] = -1 ;
            }
        }
        return solve(obstacleGrid,i-1,j-1,dp);
    }

    int solve(int[][]obstacleGrid,int i , int j, int[][] dp){
        
        if( i<0 || j<0 ){
            return 0 ;
        }
        if(obstacleGrid[i][j]==1){
            return 0 ;
        }
        if(i==0 && j==0 ){return 1 ;}
        if(dp[i][j]!=-1){
            return dp[i][j] ;
        }

        int up = solve (obstacleGrid,i-1,j,dp) ;
        int down = solve(obstacleGrid,i,j-1,dp) ;

        return dp[i][j] = up+down ;
    }
}