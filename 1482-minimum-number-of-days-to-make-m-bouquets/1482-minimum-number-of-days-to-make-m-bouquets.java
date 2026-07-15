// class Solution {

//     public boolean canMake(int[] bloomDay, int m, int k,int mid){
//         long flowers = 0;
//         long bouquet = 0 ;

//         for(int i = 0;i<bloomDay.length;i++){
//             if(mid>=bloomDay[i]){
//                 flowers++ ;
//             }
//             else{
//                 flowers = 0 ;
//             }
//             if(flowers==k){
//                 bouquet++ ;
//                 flowers = 0 ;
//             }

//             if(bouquet>=m){
//                 return true ;
//             }
//         } 
//         return false ;
//     }


//     public int minDays(int[] bloomDay, int m, int k) {
//         if(bloomDay.length<(long)m*k){
//             return -1 ;
//         }
//         if(m==0 || k==0){
//             return 0 ;
//         }
//         int min = Integer.MAX_VALUE ;
//         int max = Integer.MIN_VALUE ;

//         for(int i: bloomDay){
//             min = Math.min(min,i) ;
//             max = Math.max(max , i) ;
//         }

//         int low = min; int high = max ;

//         while(low<=high){
//             int mid = low+(high-low)/2 ;

//             if(canMake(bloomDay,m,k,mid)){
//                 high = mid -1 ;
//             }
//             else{
//                 low = mid+1 ;
//             }
            
//         }
        
//         return low ;
//     }
// }

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if (bloomDay.length < (long) m * k) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }

        int low = min;
        int high = max;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int flowers = 0;
            int bouquets = 0;

            for (int day : bloomDay) {

                if (day <= mid) {
                    flowers++;
                } else {
                    flowers = 0;
                }

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }

                // Early exit
                if (bouquets >= m) {
                    break;
                }
            }

            if (bouquets >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}