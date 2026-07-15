class Solution {
    public int mySqrt(int x) {
        long ans = 0 ;

        for(long i = 1;(i*i)<=x;i++){
            ans = i ;
        }
        return (int)ans ;
    }
}