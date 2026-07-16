class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE ;
        int min = Integer.MAX_VALUE ;
        int count = 0 ;
        for(int i: weights){
            max= Math.max(max,i) ;
            count+= i ;
            min = Math.min(min,i) ;
        }

        int low =max ; int high = count ;
       int ans = -1 ;

        while(low<=high){
            int mid = low +(high-low)/2 ;
            int cut = 0; int cday = 0;
            for(int i : weights){
                cut += i ;
                if(cut>mid){
                    cut = i ;
                    cday++ ;
                }
                else if(cut==mid){
                    cut = 0;
                    cday++ ;
                }
            }
            if(cut!=0){cday++ ;}
            if(cday<=days){
                high = mid-1 ;
                ans = mid ;
            }
            else{low = mid+1 ;}
        }
        return ans ;
    }
}