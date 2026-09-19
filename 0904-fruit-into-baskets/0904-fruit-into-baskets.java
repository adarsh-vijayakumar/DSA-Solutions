class Solution {
    public int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int right = 0, left = 0;
        Map<Integer, Integer> basket = new HashMap<>();  // Will hold no more than 3 at a time

        for(right = 0; right < fruits.length; right++){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0)+1);
            if(basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left])-1);
                if(basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }
            if(basket.size() <= 2)
                maxFruits = Math.max(maxFruits, right - left + 1);
        }
        return maxFruits;
    }
}
/*    2P & SLW

TC: O(N)
SC: O(1)


*/