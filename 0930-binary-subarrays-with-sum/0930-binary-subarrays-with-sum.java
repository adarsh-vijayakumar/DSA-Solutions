

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArraysLessThanOrEqualTo(nums, goal) - subArraysLessThanOrEqualTo(nums, goal-1);
    }
    public int subArraysLessThanOrEqualTo(int[] nums, int k){
        if(k < 0)
            return 0;
        int left = 0, right = 0, sum = 0, subArrs = 0;
        while(right < nums.length){
            sum += nums[right];
            while(sum > k){
                sum -= nums[left];
                left++;
            }
            subArrs += right - left + 1;
            right++;
        }
        return subArrs;
    }
}
/** 

Time: O(2N) ~ O(N)
Space: O(1)

 */