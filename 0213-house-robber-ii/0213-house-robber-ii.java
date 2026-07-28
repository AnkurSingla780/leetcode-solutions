class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n<=1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]) ;
        }
        int prev2 = nums[0] ;
        int prev = Math.max(nums[0],nums[1]) ;

        for(int i =2 ; i<=n-2;i++){

            int take = prev2 + nums[i] ;
            int nottake = prev ; 

            int curr = Math.max(take,nottake) ;
            prev2 = prev ;
            prev = curr ;
        }
        int ans1 = prev ;

        prev2 = nums[1] ;
        prev = Math.max(nums[1],nums[2]) ;

        for(int i =3 ; i<=n-1;i++){

            int take = prev2 + nums[i] ;
            int nottake = prev ; 

            int curr = Math.max(take,nottake) ;
            prev2 = prev ;
            prev = curr ;
        }
        int ans2 = prev ;

        return Math.max(ans1,ans2) ;
    }
}