class Solution {
    public int findContentChildren(int[] g, int[] s) {   // Input: g = [1,5,3,3,4] s = [4,2,1,2,1,3]
        Arrays.sort(g);                                  // Output: 3
        Arrays.sort(s);
        int left_sz = 0, right_gr = 0;
        while(left_sz < s.length && right_gr < g.length){   // iterate over each cookie
            if(g[right_gr] <= s[left_sz]){                  // see if that can satisfy any child
                right_gr += 1;               // if child is satisfies, move r_gr pointer for next child
            }
            left_sz += 1;               // weather or not child is satisfied, move l_sz pointer to nextr cookie
        }
        return right_gr;               // return the no. of children satisfied
    }
}
/**
Greedy Approach
Time: O(G*logG) + O(S*logS) + O(G)  | where, G: g.length, S: s.length
Space: O(1)
 */