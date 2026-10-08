class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0, closeCount = 0;
        int r = s.length()-1;
        for(int l = 0; l < s.length(); l++){
            char lChar = s.charAt(l);
            char rChar = s.charAt(r);
            if(lChar == '(' || lChar == '*')       // While traverse from left --to--> right
                openCount += 1;                    // Count of '(' + '*' should always be MORE 
            else                                           // Open-plus-Star  > Close
                openCount -= 1;                     // than count of ')' 
            
            if(rChar == ')' || rChar == '*')        // While traverse from right --to--> left
                closeCount += 1;                    // Count of ')' + '*' should always be MORE 
            else                                             // Close-plus-Star > Open
                closeCount -= 1;                     // than count of '(' 

            r -= 1;
            if(openCount < 0 || closeCount < 0)      // Any point if openCount or closeCount is not balanced
                return false;                        // Return false
        }
        return true;
    }
}
/**. 2 Pointer Approach 

Time: O(N) 
Space: O(1)

 */