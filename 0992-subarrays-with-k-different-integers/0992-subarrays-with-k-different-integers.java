// Subarray | exactly k | This approach
// Same: (930)Binary Subarrays with Sum, (1248) Count Nice SubArrys

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countNoOfSubarrays(nums, k) - countNoOfSubarrays(nums, k-1);
    }

    public int countNoOfSubarrays(int[] nums, int k){
        if(k <= 0) return 0;
        int left = 0, right = 0, count = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while(map.size() > k){
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left += 1;
            }
            ans += (right - left + 1);
            right += 1;
        }
        return ans;
    }
}
/**
Time: O(2N) ~ O(N)
Space: O(N)

 */