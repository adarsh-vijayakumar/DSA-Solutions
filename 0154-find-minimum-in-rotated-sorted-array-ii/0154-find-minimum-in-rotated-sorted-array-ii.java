class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                ans = Math.min(ans, nums[mid]);
                low += 1;
                high -= 1;
                continue;
            }
            if(nums[low] <= nums[mid]){           // STEP1: Identify sorted half
                ans = Math.min(ans, nums[low]);   // in sorted half, you know the min
                low = mid + 1;                     // Take min, and Eliminate sorted half
            }else{
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }
}
/**    
TC: O(log.n) | Worst case: O(n/2)
SC: O(1)

 */