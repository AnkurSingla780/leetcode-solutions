class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();

        // int[][] dp = new int[n][n];
        int[] prev = new int[n] ;
        int[] curr = new int[n] ;

        for(int i = 0 ; i<triangle.get(n-1).size();i++){
            prev[i] = triangle.get(n-1).get(i) ;
        }
        for(int i =n-2 ; i>=0;i--){
            for(int j = triangle.get(i).size() -1 ;j>=0;j--){
                int up = triangle.get(i).get(j) + prev[j] ;
                int diagonal = triangle.get(i).get(j) + prev[j+1] ;
                curr[j] = Math.min(up,diagonal) ;
            }
            prev = curr.clone() ;
        }
        return prev[0] ;
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