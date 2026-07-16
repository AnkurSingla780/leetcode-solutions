class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;

        for(int i: nums){
            max = Math.max(max,i) ;
            min = Math.min(min,i) ;
        }

        int low = 1 ;
        int high = max ;
        int ans = -1 ;
        while(low<=high){
            int mid = low+(high-low) /2 ;
            int count = 0;

            for(int i : nums){
                count+= ((i+mid-1)/mid) ;

                if(count>threshold){
                    break ;
                }
            }
            if(count<=threshold){
                high = mid -1 ;
                ans = mid ;
            }
            else{low = mid+1 ;}

        }

        return ans ;
    }
}