class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int i = 0 ; i<triangle.get(n-1).size();i++){
            dp[n-1][i] = triangle.get(n-1).get(i) ;
        }
        for(int i =n-2 ; i>=0;i--){
            for(int j = triangle.get(i).size() -1 ;j>=0;j--){
                int up = triangle.get(i).get(j) + dp[i+1][j] ;
                int diagonal = triangle.get(i).get(j) + dp[i+1][j+1] ;
                dp[i][j] = Math.min(up,diagonal) ;
            }
        }
        return dp[0][0] ;
        // for (int[] row : dp) {
        //     Arrays.fill(row, Integer.MIN_VALUE);
        // }

        // return solve(0, 0, triangle, dp);
    }

    public int solve(int i, int j, List<List<Integer>> triangle, int[][] dp) {

        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, triangle, dp);
        int diagonal = solve(i + 1, j + 1, triangle, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
}