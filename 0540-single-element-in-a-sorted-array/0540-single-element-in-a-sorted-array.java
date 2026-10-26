class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];            // To avoid writing extra boundary conditions
        if(nums[n-1] != nums[n-2]) return nums[n-1];     // manually check for 0 and n-1 indexes
        int low = 1, high = n-2;                        // AND, you trim the search space
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
                return nums[mid];
            if((mid % 2 == 1 && nums[mid] == nums[mid-1]) ||       // you're standing at odd && left is equal
                (mid % 2 == 0 && nums[mid] == nums[mid+1]))        // OR -----,,--------even, && right is equal
                low = mid + 1;                                // You are on left half of SE | SE is on right, Therefore eliminate left half
            else
                high = mid - 1;                             // You are on right half of SE | SE is on left, Therefore eliminate right half
        }
        return -1;
    }
}
/**
Time: O(log(n))
Space: O(1)

0,1,2,3,4,5, 6, 7,8,9,10
e,o,e,o,e,o, e, o,e,o,e
1,1,2,2,3,3, 4, 5,5,6,6
---e,o------SE---o,e-----  // before the SE its (e,o) pattern | After SE it's (o,e)

 */