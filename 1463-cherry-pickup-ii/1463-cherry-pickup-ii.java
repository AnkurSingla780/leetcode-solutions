class Solution {
    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] d = {-1, 0, 1};

        int[][][] dp = new int[n][m][m];

        for (int[][] i : dp) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        return solve(0, 0, m - 1, grid, d, dp);
    }

    public int solve(int i, int j1, int j2, int[][] grid,
                     int[] d, int[][][] dp) {

        if (j1 < 0 || j2 < 0 ||
            j1 >= grid[0].length || j2 >= grid[0].length) {
            return -100000000;
        }

        if (i == grid.length - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int maxi = -100000000;

        for (int x : d) {
            for (int y : d) {

                int value = 0;

                if (j1 == j2) {
                    value = grid[i][j1];
                } else {
                    value = grid[i][j1] + grid[i][j2];
                }

                value += solve(i + 1, j1 + x, j2 + y,
                               grid, d, dp);

                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}