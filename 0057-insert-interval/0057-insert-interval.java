class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Left part of intervals i.e Non-Overlapping
        while(i < n && intervals[i][1] < newInterval[0]){    
            ans.add(intervals[i]);                           
            i += 1;                                         // already checked endTime is clashing
        } 

        // Middle part of intervals i.e Overlapping: SO LOOP UNTIL START TIME IS NOT CLASHING (couldn't figr out)
        while(i < n && intervals[i][0] <= newInterval[1]){                  
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);             
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i += 1;
        }
        ans.add(newInterval);

        // Right part of intervals i.e Non-Overlapping
        while(i < n){
            ans.add(intervals[i]);                          // Add the remaining Non-Overlapping as is
            i += 1;
        }

        int[][] res = new int[ans.size()][2];             // RETURN in int[][] format
        for(int j = 0; j < ans.size(); j++){             
            res[j] = ans.get(j);
        }

        return res;
    }
}
/**
Time: O(N)
Space: O(N) space only for the storing the result

 */