class Solution {      
    public int maxScore(int[] cardPoints, int k) {
        int maxPoints = 0, right = cardPoints.length-1;
        int leftSum = 0, rightSum = 0;
        
        for(int left = 0; left < k; left++)      // Take ALL from Left
            leftSum += cardPoints[left];

        maxPoints = leftSum;                     // Assign to MaxPoints. | O from left.

        for(int left = k-1; left >= 0; left--){
            leftSum -= cardPoints[left];             // Shrink left by 1
            rightSum += cardPoints[right];           // expand right by 1
            right -= 1;
            maxPoints = Math.max(maxPoints, leftSum + rightSum);      // left + right is the window
        }

        return maxPoints;
    }
}
/**
Time: O(2k) ~ O(k)
Space: O(1)
 */