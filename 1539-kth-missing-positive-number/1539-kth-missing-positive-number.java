class Solution {
    public int findKthPositive(int[] arr, int k) {
        
       int  high = arr[arr.length -1] +k ;
        int j = 0 ;
        for(int i = 1 ;i<=high;i++){
            if(j<arr.length && i!=arr[j]){
                k-- ;
            }
            else if(j<arr.length && i==arr[j]){j++ ;}

            else if(j>=arr.length){
                k-- ;
            }

            if(k==0){
                return i ;
            }

        }

        return -1 ;
    }
}