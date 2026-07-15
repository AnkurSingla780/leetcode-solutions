class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE ;
        
        for(int i: piles){
            max = Math.max(i,max) ;
        }

        int low = 1 ;
        int high = max ;
        int ans = max ;
        while(low<=high){
            long hr = 0 ;
            int mid = low+(high - low) /2 ;
            for(int j:piles){
                hr +=((j+mid-1)/mid) ;
            }
            if(hr>h){
                low = mid +1 ;
            }
            else{
                high = mid -1 ;
                ans = mid ;
            }
        }

        return ans ;
    }
}