class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length ;
        int n = obstacleGrid[0].length ;
        
        int[][] dp = new int[m][n] ;
        for(int[] i : dp){
            Arrays.fill(i,-1) ;
        }
        return solve(m-1,n-1,obstacleGrid,dp) ;
    }
    public int solve(int m ,int n , int[][] obstacleGrid , int[][] dp){
        if (m < 0 || n < 0)
            return 0;

        if (obstacleGrid[m][n] == 1)
            return 0;

        if (m == 0 && n == 0)
            return 1;
            
        if(dp[m][n]!=-1){
            return dp[m][n] ;
        }

        return dp[m][n] = solve(m-1,n,obstacleGrid,dp) + solve(m,n-1,obstacleGrid,dp) ;
    }
}