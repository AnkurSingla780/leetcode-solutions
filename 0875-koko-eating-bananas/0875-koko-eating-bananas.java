// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int max = Integer.MIN_VALUE ;
        
//         for(int i: piles){
//             max = Math.max(i,max) ;
//         }

//         int low = 1 ;
//         int high = max ;
//         int ans = max ;
//         while(low<=high){
//             long hr = 0 ;
//             int mid = low+(high - low) /2 ;
//             for(int j:piles){
//                 hr +=((j+mid-1)/mid) ;
//                 if (hr > h) break;
//             }
//             if(hr>h){
//                 low = mid +1 ;
//             }
//             else{
//                 high = mid -1 ;
//                 ans = mid ;
//             }
//         }

//         return ans ;
//     }
// }

class Solution {

    private boolean canEat(int[] piles, int speed, int h) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile + (long)speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}