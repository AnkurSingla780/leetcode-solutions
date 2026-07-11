class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE ;
        int j = 0;
        for(int i = 0 ;i<arr.length - 1; i++){
            j=i+1 ;
            min = Math.min(min,arr[j]-arr[i]);
        }

        List<List<Integer>> list = new ArrayList<>() ;
        for(int i = 0 ;i<arr.length - 1; i++){
            j=i+1 ;
            if(arr[j]-arr[i]==min){
                list.add(Arrays.asList(arr[i],arr[j])) ;
            }
        }

        return list ;
    }
}