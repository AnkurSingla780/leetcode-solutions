class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list= new ArrayList<>() ;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0] ,b[0]) ) ;
        int start = intervals[0][0];
        int end = intervals[0][1] ;
        for(int i = 1;i<intervals.length;i++){
            if(end>=intervals[i][0]  ){
                end = Math.max(intervals[i][1],end) ;
                
            }
            else{
                list.add(Arrays.asList(start,end)) ;
                start = intervals[i][0];
                end = intervals[i][1] ;
            }
        }   
        list.add(Arrays.asList(start,end)) ;     

        int[][] arr = new int[list.size()][2] ;

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr ;
    }
}