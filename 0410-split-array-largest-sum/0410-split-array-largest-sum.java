class Solution {

    public int partition(int[] nums, int mid,int k){
        int cpart = 1 ; int left = 0 ;
        for(int i: nums){
            left+= i ;
            // if(left==mid){
            //     cpart++ ;
            //     left = 0 ;
            // }
           if(left>mid){
                cpart++ ;
                left = i ;
            }
        }
        return cpart ;
    }


    public int splitArray(int[] nums, int k) {
        int max= Integer.MIN_VALUE ;
        int sum = 0 ;
        for(int i: nums){
            max = Math.max(max,i) ;
            sum+=i ;
        }

        int low = max ; int high = sum ;

        while(low<=high){
            int mid = low +(high -low)/2 ;
            int count = partition(nums,mid,k) ;
            if(count>k){
                low = mid+1 ;
            }
            else{high = mid - 1 ;}
        }
        return low ;
    }
}