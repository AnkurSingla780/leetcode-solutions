class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0){
            return false;
        }

        int[][] dp = new int[nums.length][sum / 2 + 1];

        for(int[] i : dp){
            Arrays.fill(i, -1);
        }

        return solve(nums.length - 1, sum / 2, dp, nums);
    }

    public boolean solve(int i, int target, int[][] dp, int[] nums){

        if(target == 0){
            return true;
        }

        if(i == 0){
            return target == nums[0];
        }

        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }

        boolean Nottake = solve(i - 1, target, dp, nums);

        boolean take = false;

        if(target >= nums[i]){
            take = solve(i - 1, target - nums[i], dp, nums);
        }

        dp[i][target] = (Nottake || take) ? 1 : 0;

        return Nottake || take;
    }
}