class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0, maxIdx = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxIdx = Math.max(maxIdx, i + nums[i]);   // At every i, you're Greedy & considering (keep track of)
            //                                         what's the max 'pos'/or max index I can reach from here(i)
            if(i == pos){                   
                pos = maxIdx;             // once you reach the 'pos', Jump to the maxIdx possible from here
            }
        }
        return pos >= nums.length-1;
    }
}
/**
Greedy Approach
Time: O(N)
Space: O(1)
 */