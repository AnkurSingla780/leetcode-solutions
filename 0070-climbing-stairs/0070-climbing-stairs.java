class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1] ;
        // Arrays.fill(dp,-1) ;
        if(n<=1){
            return n ;
        }
        // dp[1] =1 ;
        // dp[2] = 2 ;
        // for(int i = 3 ; i<=n ;i++){
        //     dp[i] = dp[i-1] + dp[i-2] ;
        // }
        // return dp[n] ;

        int prev = 2 ;
        int prev2 = 1 ;

        for(int i = 3 ; i<=n ;i++){
            int curr  = prev + prev2 ;
            prev2 = prev ;
            prev = curr ;
            
        }
        return prev ;

        // return solve(n,dp) ;
        
    }

    // public int solve(int n , int[] dp){
    //     if(n==2){
    //         return 2 ;
    //     }
    //     if(n==1){
    //         return 1 ;
    //     }

    //     if(dp[n]!=-1){
    //         return dp[n] ;
    //     }

    //     int n1 = n - 1 ;
    //     int n2 = n -2 ;

    //     return dp[n] = solve(n1,dp) + solve(n2,dp) ;
    // }
}