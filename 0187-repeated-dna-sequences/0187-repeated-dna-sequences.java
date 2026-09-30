class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> inAns = new HashSet<>();

        if(s.length() <= 9)
            return ans;

        StringBuilder cur = new StringBuilder(s.substring(0,10));
        seen.add(cur.toString());

        for(int i = 10; i < s.length(); i++){
            cur.deleteCharAt(0);
            cur.append(s.charAt(i));

            if(seen.contains(cur.toString())){          // if already seen
                if(!inAns.contains(cur.toString())){    // if Not in inAns
                    ans.add(cur.toString());            // seeing this for the 2nd time
                    inAns.add(cur.toString());          // add it to ans and inAns set  
                }                                   // else: means seeing it for 3rd or more time
            }                                                // already in the ans & inAns

            seen.add(cur.toString());                // DON'T forget to add the cur to the seen
        }
        
        return ans;
    }
}
/*
RVS : Hashing (2 hashes) + Sliding window

TC: O(N) | For a constant L = 10
SC: 0(N) | For a constant L = 10
 */