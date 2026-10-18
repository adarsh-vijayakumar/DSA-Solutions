class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return mid;
            //                                              Step1: Identify the sorted half
            else if(nums[low] <= nums[mid]){       
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
        return -1;
    }
}
/**
TC: O(log n)
SC: O(1)

B.S works by eliminating halfs. So to eliminate a hlf, we have to check if target is present/lies in which half
We can only check in the sorted half. Since rotated at only 1 pivot We're sure 1 half will be sorted

So, STEP1: figure out which half is sorted | STEP2: Check if target is present/lies in that sorted half
Then, very easy, obvious STEP3: Eliminate the half


 */