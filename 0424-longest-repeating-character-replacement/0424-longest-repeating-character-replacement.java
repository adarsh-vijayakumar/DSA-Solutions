class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, maxlen = 0, maxF = 0;     // maxF: freq of max times repeating char in win (left - right)
        int[] hash = new int[26];                   // In a wind, we'll replace other than the maxF chars (not touch maxF chars)
        while(r < s.length()){
            hash[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, hash[s.charAt(r) - 'A']);
            // no. of replacements (NoR): winLen - maxF > k // THIS IS THE KEY LOGIC TO FIGURE OUT
            while((r - l + 1) - maxF > k){      // IF the NoR > k
                hash[s.charAt(l) - 'A']--;      // shrink from left: decrease LeftChar count & incr left by 1
                l += 1;                         // calc maxF is waste: cz, freq is decrsd, even if maxF is calc it'll still be invalid
            }                                   // as long as winLen doesn't increase
            maxlen = Math.max(maxlen, r-l+1);
            r += 1;
        }
        return maxlen;
    }
}
/**    
Time: O(2N)
Space: O(26) ~ O(1)

can be done in O(N) time as well

 */