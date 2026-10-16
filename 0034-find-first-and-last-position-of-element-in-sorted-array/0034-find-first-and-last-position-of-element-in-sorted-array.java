class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        if(first == -1)
            return new int[] {-1, -1};        
        int last = findLastPosition(nums, target);
        System.out.println("Count of the target: " + (last - first + 1));   // VARIANT-1: count of element
        return new int[] {first, last};
    }
    public int findFirstPosition(int[] nums, int target){
        int first = -1;                                     // set the ans to default -1
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                first = mid;                    
                high = mid - 1;                 // Copy the mid - 'Can be the ans'
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return first;                                          
    }
    public int findLastPosition(int[] nums, int target){     // VARIANT2: Find the No. of (count) unique elements in sorted Array
        int last = -1;                                      // Expected TC: K * log(N) where K is the no. of unique ele
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                last = mid;
                low = mid + 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last;
    }
} /*                  Array, Binary Search

TC: O(log (N))
SC: O(1)

 */