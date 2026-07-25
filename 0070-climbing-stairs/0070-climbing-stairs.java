class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        return solve(n,dp) ;
        // return dp[n] ;
    }

    public int solve(int n , int[] dp){
        if(n==2){
            return 2 ;
        }
        if(n==1){
            return 1 ;
        }

        if(dp[n]!=-1){
            return dp[n] ;
        }

        int n1 = n - 1 ;
        int n2 = n -2 ;

        return dp[n] = solve(n1,dp) + solve(n2,dp) ;
    }
}