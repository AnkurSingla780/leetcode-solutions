class Solution {
    public int[] twoSum(int[] nums, int target) {
     HashMap<Integer,Integer> map = new HashMap<>();

    //  for(int i =0;i<nums.length;i++){
    //     map.put(nums[i],i);
    //  }   
    int remains ;
    for(int i =0;i<nums.length;i++){
            remains = target - nums[i];

            if(map.containsKey(remains) && map.get(remains) != i){
                return new int[] {i,map.get(remains)};
            }
            map.put(nums[i], i);
        } 

        return new int[]{ } ;
    }
}