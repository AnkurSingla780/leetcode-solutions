class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int[] nums, int index, List<Integer> output, List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(output);
            return;
        }

        List<Integer> op1 = new ArrayList<>(output);

        List<Integer> op2 = new ArrayList<>(output);
        op2.add(nums[index]);

        solve(nums, index + 1, op1, ans);
        solve(nums, index + 1, op2, ans);
    }
}