class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);
        int count = 0;

        for(int i = 0; i < s.length(); i++){    // subStr ending at idx i

            lastSeen[s.charAt(i) - 'a'] = i;
            
            // Actlly, no need of adding this if check. Makes no diff
            // bcz, -1 and +1 will give 0, adding 0 to count makes no diff

            if(lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1)
                count += Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])) + 1;

                /* when you get a subStr with all 3 chars: get the min of last seen idxs of a,b,c
                   that will be the starting idx for this window, (ending idx being i) - The valid windw
                   all the chars before that starting idx, will also make valid subStr    
                   So, add those many subStrs to count. i.e Adding Min(lastSeen) + 1   
                 a)  Min(lastSeen) -for-> No. of Substrs that can be formed with startIdx as each idx before Min(LstSn)  
                 b)   +1 --for--> The current valid window itself. Substr starting with Min(LstSn)    */
        }
        return count;
    }
}

/**

Time: O(N)
Space: O(1)

 */