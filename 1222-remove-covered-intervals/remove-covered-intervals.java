class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> {
            if(a[0] != b[0]){
                return a[0]-b[0];
            }else{
                return b[1]-a[1]; //agr starting point same hai toh in desc by end dig ex: 1,4  1,6-> 1,6 1,4
            }
        });

        int maxEnd = intervals[0][1];
        int count = 1;
        for(int i=1 ; i< intervals.length ;i++){
           
                if(intervals[i][1] <= maxEnd  ){ //convered
                    continue;
                }else{
                    count++;
                    maxEnd = intervals[i][1];
                }
        }
        return count;
    }
}