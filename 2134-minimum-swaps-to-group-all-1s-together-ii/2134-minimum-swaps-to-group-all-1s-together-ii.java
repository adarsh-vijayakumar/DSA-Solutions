class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0, n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
                ones++;
        }
        int zeros = 0, leastZeros = 0;
        for(int j = 0; j < ones; j++){
            if(nums[j] == 0)
                zeros++;
        }
        leastZeros = zeros;
        for(int j = ones; j < nums.length*2; j++){
            if(nums[j % n] == 0)
                zeros++;
            if(nums[(j - ones)%n] == 0)
                zeros--;
            leastZeros = Math.min(leastZeros, zeros);
        }
        return leastZeros;
    }
}

/**
TC: O(2N) ~ 0(N)
SC: 0(1)

Sliding Window: Window with min No. of Zeros

    1) We have to check all possible windows of len/size 'ones'
    2) Keeping track of min No. of zeros in each window

*/

