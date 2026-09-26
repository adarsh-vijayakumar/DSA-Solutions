class Solution {      

    public int numberOfSubarrays(int[] nums, int k) {
        return findSubArrays(nums, k) - findSubArrays(nums, k-1);
    }

        // No. of nice Subarrays LESS than OR Equal to goal
    public int findSubArrays(int[] nums, int goal){
        if(goal < 0)
            return 0;
        int left = 0, right = 0, count = 0, sum = 0;
        while(right < nums.length){                  // O(N) version won't work for this
            sum += nums[right] % 2;
            while(sum > goal){            // CANNOT change this to if | O(N) XX
                sum -= nums[left] % 2;
                left += 1;
            }
                                         // XX if(sum <= goal)   | DON'T 
            count += (right - left + 1);
            right += 1;
        }
        return count;
    }
}
/*

TC: O(2N) ~ O(N)
SC: O(1)

*/