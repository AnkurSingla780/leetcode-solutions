class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < matrix[0].length; k++) {
            ans = Math.min(ans, solve(0, k, matrix, dp));
        }

        return ans;
    }

    public int solve(int i, int j, int[][] matrix, int[][] dp) {

        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == matrix.length - 1) {
            return matrix[i][j];
        }

        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        int down = solve(i + 1, j, matrix, dp);
        int left = solve(i + 1, j - 1, matrix, dp);
        int right = solve(i + 1, j + 1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
    }
}