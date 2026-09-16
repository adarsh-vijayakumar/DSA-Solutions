class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while(right < s.length()){
            char curCh = s.charAt(right);
            if(map.containsKey(curCh)){            // if already seen
                if(map.get(curCh) >= left)         // AND in the range of cur window
                    left = map.get(curCh) + 1;     // directly move left pointer to after the seen idx   
            }
            maxLen = Math.max(maxLen, right - left + 1);
            map.put(curCh, right);
            right += 1;
        }
        return maxLen;
    }
}
/**
Most Optimal possible: 2P & Sliding window
Time: O(N)
Space: O(1)

 */