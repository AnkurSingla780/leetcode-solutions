class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int [m+1][n+1] ;
        for(int[] i : dp){
            Arrays.fill(i,-1) ;
        }
        return solve(m,n,dp) ;
    }

    public int solve(int m , int n , int[][] dp){

        if(m==1 || n==1){
            return 1 ;
        }

        if(dp[m][n]!=-1){
            return dp[m][n] ;
        }
        int val = solve(m-1,n,dp) + solve(m,n-1,dp) ; 

        return dp[m][n] = val ;
    }
}