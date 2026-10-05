class Solution {
    public int eraseOverlapIntervals(int[][] Intervals) {

        Arrays.sort(Intervals, (a,b) -> a[1] - b[1]);
        int removed = 0, curEnd = Intervals[0][1];        

        for(int i = 1; i < Intervals.length; i++){
            if(Intervals[i][0] < curEnd){
                removed++;
                continue;
            }
            curEnd = Intervals[i][1];
        }

        return removed;
    }
}
/**
TC: O(N.logN)

SC: O(logN)  | space taken for sorting

 */
