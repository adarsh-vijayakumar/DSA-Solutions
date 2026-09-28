class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
 
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, sIdx = 0, counter = tMap.size();
        while(right < s.length()){
            char r_ch = s.charAt(right);
            if(tMap.containsKey(r_ch)){
                tMap.put(r_ch, tMap.get(r_ch) - 1);
                if(tMap.get(r_ch) == 0) counter -= 1;
            }
            while(counter == 0){
                char l_ch = s.charAt(left);
                if(right - left + 1 < minLen){    
                    minLen = right - left + 1;
                    sIdx = left;
                }
                if(tMap.containsKey(l_ch)){
                    tMap.put(l_ch, tMap.get(l_ch) + 1);
                    if(tMap.get(l_ch) > 0) counter += 1;
                }
                left += 1;
            }
            right += 1;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(sIdx, sIdx + minLen);
    }
}
/**
TC: O(S + T) | Where S, T are lengths of strings s and t

SC: O(256) | For storing tMap


 */