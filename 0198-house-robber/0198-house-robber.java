// import java.util.Arrays;

// class Solution {
//     public int rob(int[] nums) {
//         if (nums.length == 1) {
//             return nums[0];
//         }

//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, -1);

//         return solve(0, nums, dp);
//     }

//     public int solve(int i, int[] nums, int[] dp) {

//         if (i >= nums.length) {
//             return 0;
//         }

//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         int take = nums[i] + solve(i + 2, nums, dp);
//         int skip = solve(i + 1, nums, dp);

//         dp[i] = Math.max(take, skip);

//         return dp[i];
//     }
// }

class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int prev2 = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            int take = nums[i] + prev2;
            int skip = prev;

            int curr = Math.max(take, skip);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}