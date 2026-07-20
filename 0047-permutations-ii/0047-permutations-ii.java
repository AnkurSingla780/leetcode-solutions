class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
                List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums) ;
        List<Integer> input = new ArrayList<>();
        for (int x : nums) {
            input.add(x);
        }

        solve(ans, input, new ArrayList<>());
        List<List<Integer>> ans1 = new ArrayList<>();
        Map<List<Integer>, Boolean> map = new HashMap<>();

        for (List<Integer> i : ans) {

            if (!map.containsKey(i)) {
                map.put(i, true);
                ans1.add(i);
            }
        }

        return ans1;

    }

    public void solve(List<List<Integer>> ans,
                      List<Integer> input,
                      List<Integer> output) {

        if (input.size() == 0) {
            ans.add(output);
            return;
        }

        for (int i = 0; i < input.size(); i++) {

            List<Integer> inputCopy = new ArrayList<>(input);
            List<Integer> outputCopy = new ArrayList<>(output);

            int x = inputCopy.get(i);

            outputCopy.add(x);
            inputCopy.remove(i);

            solve(ans, inputCopy, outputCopy);
        }
    }
}

