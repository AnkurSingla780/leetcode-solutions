import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }

    public int solve(int i, int[] nums, int[] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int take = nums[i] + solve(i + 2, nums, dp);
        int skip = solve(i + 1, nums, dp);

        dp[i] = Math.max(take, skip);

        return dp[i];
    }
}