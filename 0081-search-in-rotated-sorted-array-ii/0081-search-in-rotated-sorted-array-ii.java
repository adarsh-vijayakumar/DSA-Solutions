class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target)                         // First check for mid 
                return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){   // The only scenario when I can't figure sorted half
                low += 1;                // since mid is already checked, just trim
                high -= 1;             // If so, then just trim down the search space
                continue;               
            }                           
            else if(nums[low] <= nums[mid]){        // Step1: Identify the sorted half
                if(nums[low] <= target && target <= nums[mid])   // Step2: check if target is in sorted half
                    high = mid - 1;                              // Step3: Eliminate the half
                else
                    low = mid + 1;
            }else{                                               // right half is sorted
                if(nums[mid] <= target && target <= nums[high])    // NOTE: only in sorted half we can check
                    low = mid + 1;                                // if target is present or not
                else
                    high = mid - 1;
            }
        }
        return false;
    }
}
/**
TC: O(log n) | In worst case O(n/2)
SC: O(1)
            ** Selected is the only extra added
B.S works by eliminating halfs. So to eliminate a hlf, we have to check if target is present/lies in which half
We can only check in the sorted half. Since rotated at only 1 pivot We're sure 1 half will be sorted

So, STEP1: figure out which half is sorted | STEP2: Check if target is present/lies in that sorted half
Then, very easy, obvious STEP3: Eliminate the half
 */