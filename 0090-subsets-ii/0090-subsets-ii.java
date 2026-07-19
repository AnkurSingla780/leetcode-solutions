class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>() ;
        List<Integer> output = new ArrayList<>() ;
        Arrays.sort(nums) ;
        solve(nums,0,output,ans) ;
        return ans ;
    }

    public void solve(int[] nums , int index ,List<Integer> output , List<List<Integer>> ans ){
        if(index==nums.length && !ans.contains(output)){
            ans.add(output) ;
            return ;
        }
        else if (index==nums.length && ans.contains(output)){
            return ;
        }

        List<Integer> op1 = new ArrayList<>(output) ;
        List<Integer> op2 = new ArrayList<>(output) ;
        op2.add(nums[index]) ;

        solve(nums,index+1,op1,ans) ;
        solve(nums,index+1,op2,ans) ;

    }
}