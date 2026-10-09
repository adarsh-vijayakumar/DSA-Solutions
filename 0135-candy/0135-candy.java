class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int[] left = new int[n];               // give Candies considering only left neighbour 
        left[0] = 1;                     
        for(int i = 1; i < n; i++){             
            if(ratings[i] > ratings[i-1])     // if cur child has more rating than left child
                left[i] = left[i-1] + 1;      // he gets 1 more than left child. 
            else 
                left[i] = 1;                  // Else he gets Min 1
        }

        int[] right = new int[n];
        right[n-1] = 1;                         // Greedily assign ONLY 1     
        for(int i = n-2; i >= 0; i--){          // give Candies considering only right neighbour
            if(ratings[i] > ratings[i+1])
                right[i] = right[i+1] + 1;       // Greedily assign just 1 more, to satisfy condtn
            else
                right[i] = 1;                   // Greedy, just give 1
        }

        int sum = 0;
        for(int i = 0; i < n; i++){                    // take the Max of left & right
            sum += Math.max(left[i], right[i]);       // To satisfy both neighbours
        }
        return sum;
    }
}
/**
Time: O(2N) ~ O(N)
Space: O(2N) ~ O(N)
 */