class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1 ;
        int min = Integer.MAX_VALUE ;
        while(low<=high){
            int mid = low + (high - low)/2 ;
            if(nums[mid]<min){
                min = nums[mid] ;
            }
            if(nums[high]>nums[mid]){
                high = mid;
            }
            else{
                low = mid +1 ;
            }
        }
        return min ;
    }
}