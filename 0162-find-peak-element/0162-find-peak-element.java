class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(nums.length == 1) return 0; 
        if(nums[0] > nums[1]) return 0;                 // To avoid writing extra boundary conditions
        if(nums[n-1] > nums[n-2]) return n-1;            // manually check for 0 and n-1 indexes

        int low = 1, high = n-2;                       // AND, you trim the search space
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] > nums[mid-1]){       // mid is on inc slope. Peak on right
                low = mid + 1;                 // Elmnte left (inc slope) | inc slope like this "/"
            }                          // by giving else the "dip" scenario is handled i.e goes to else block
            else{                        // "dip" where dec & inc slope meet (opp of peak) like this "\/"
                high = mid - 1;                // mid is on (right) dec slope. (peak on left. So elmnt right)
            }                                  // dec slope like this "\"
        }                                      
        return -1;
    }
}

/* B.S: 
Time: O(log(n))
Space: O(1)
 */
 /*
 Binary Search why? Bcz, to form a peak there should be inc seqnce (immediately) followed by dev seqnce
 Eg: [1,2,3,4,5,(7),3,1] | 7 is peak. Here 1 to 7 is inc slope and 3 to 1 is dec slope. 
 For each mid check: are you on inc slope, IF SO then - move Right by elimntng left half
  are you on dec slope, IF SO then - move Left by elimntng right half

  */