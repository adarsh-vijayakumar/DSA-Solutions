class Solution {
    public int fillCups(int[] amount) {
        int sec = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int num : amount){
            if(num > 0)
                maxHeap.add(num);         // Since 1st pref to remove 2 cups in a sec
        }                                // Take maxHeap, more no. of cups comes first

        while(!maxHeap.isEmpty()){
            if(maxHeap.size() >= 2){           // Greedily, 1st pref to fill 2 cups in a sec
                int cup1 = maxHeap.poll();
                int cup2 = maxHeap.poll();
                if(cup1 - 1 > 0) maxHeap.add(cup1-1);    // after filling, still cups > 0
                if(cup2 - 1 > 0) maxHeap.add(cup2-1);    // i.e. Add to PQ only if (+ve) cups > 2
            }else{
                int cup1 = maxHeap.poll();
                if(cup1 - 1 > 0) maxHeap.add(cup1-1);                   // Next obvious priority
                                                            // Remove only 1 cup in a sec
            }
            sec += 1;
        }

        return sec;
    }
}/**
        Greedy 1st & Maxheap
TC: O(1) [Actually O(sum) where sum: sum of the i/p array amount[]]
           because, 0 <= amount[i] <= 100 The number of operations will never exceed a 
           fixed upper bound (at most ~150 iterations),   

SC: O(1)   | Given input size is always fixed  = 3
    
 */