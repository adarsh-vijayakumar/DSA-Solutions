class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int left = 0, right = 0;
        int ans = 0, product = 1;    // initialize product = 1

        while(right < nums.length){

            product *= nums[right];    // expand from right by *=

            while(product >= k){
                product /= nums[left];   // exclude by doing /=
                left += 1;                // shrink from left
            }

            ans += (right - left + 1);    // No. of subarrays 'ending at right'
            right += 1;                         //|_> will be = len of window
        }

        return ans;
    }
}
/**
    Sliding Window
TC: O(N)
SC: O(1)
 */