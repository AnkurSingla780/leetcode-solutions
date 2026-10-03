class Solution {

    Boolean[][] dp;

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums) {
            sum += x;
        }

        if (sum % 2 != 0) {
            return false;
        }

        dp = new Boolean[nums.length][sum / 2 + 1];

        return solve(nums, nums.length - 1, 0, sum);
    }

    boolean solve(int[] nums, int i, int target, int sum) {

        if (target == sum / 2) {
            return true;
        }

        if (i < 0) {
            return false;
        }

        if (dp[i][target] != null) {
            return dp[i][target];
        }

        boolean nottake = solve(nums, i - 1, target, sum);

        boolean take = false;

        if (target + nums[i] <= sum / 2) {
            take = solve(nums, i - 1, target + nums[i], sum);
        }

        return dp[i][target] = nottake || take;
    }
}