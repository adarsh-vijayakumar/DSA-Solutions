class Solution {         
    public int longestOnes_2N(int[] nums, int k) {       // TC: O(N) + O(N) = O(2N) ~ O(N)
        int left = 0, right = 0, zeros = 0, maxlen = 0;
        while(right < nums.length){             
            if(nums[right] == 0) zeros += 1;
            while(zeros > k){
                if(nums[left] == 0) zeros -= 1;
                left += 1;
            }
            maxlen = Math.max(maxlen, right - left + 1);
            right += 1;
        }
        return maxlen;
    }                  

    //                          Most Optimal below

    public int longestOnes(int[] nums, int k) {                 // TC: O(N)
        int left = 0, right = 0, zeros = 0, maxlen = 0;
        while(right < nums.length){             
            if(nums[right] == 0) zeros += 1;
            if(zeros > k){                                      // Optimization: Just change while -to-> if
                if(nums[left] == 0) zeros -= 1;
                left += 1;
            }
            if(zeros <= k)                                     // add the if(given-cond)
                maxlen = Math.max(maxlen, right - left + 1);        // Calc maxlen ONLY if(cond) meets
            right += 1;
        }
        return maxlen;
    }
}
/**
Given prob should be understood as: Find longest subarray with atmost K Os

Time: O(N) - most optimal
Space: O(1)

 */