class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[low] <= nums[high]){         // ONLY for optimization
                ans = Math.min(ans, nums[low]);   // pivot idx is crossed 
                break;                             // entire low to high is sorted
            }
            if(nums[low] <= nums[mid]){            // STEP1: Identify sorted half
                ans = Math.min(ans, nums[low]);    // Pick the min in sorted half
                low = mid + 1;                     // Eliminate the sorted half
            } else{
                ans = Math.min(ans, nums[mid]);     // Reason: In unsorted part 
                high = mid - 1;                      // You don't know which is min
            }
        }
        return ans;
    }
}
/**
TC: O(log N)
SC: O(1)

Just keep picking the min ele from the sorted part 
and keep eliminating the sorted half
Optimization:
nums[low] <= nums[high] :the search space is sorted
because we've crossed the pivot idx of rotation AND SO
we can check/pick nums[low] and break out
 */