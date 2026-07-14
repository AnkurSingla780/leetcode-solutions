class Solution {
    public int search(int[] nums, int target) {
        int low = 0 ;
        int k = target ;
        int high = nums.length - 1 ;
        while(low<=high){
            int mid = low + (high - low)/2 ;
            if(nums[mid]==target){return mid ;}

            if(nums[low]>nums[mid]){
                if(k>nums[mid] && nums[high]>=k){
                    low = mid+1 ;
                }
                else{high = mid-1;}
            }

            else{
                if(k>=nums[low] && k<nums[mid]){
                    high = mid -1 ;
                }
                else{low = mid+1 ;}
            }
        }
        return -1 ;
    }
}