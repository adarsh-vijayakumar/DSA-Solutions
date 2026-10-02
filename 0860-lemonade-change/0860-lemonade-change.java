class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;         // No need to track 20s
        for(int payed : bills){          // Cz, we can't return it as change. So no use of 20's for us
            if(payed == 5){
                fives += 1;              // payed 5. Take it
            }else if(payed == 10){
                if(fives >= 1){          // payed 10. Check the ONLY possible way to give change
                    tens += 1;           // Take the 10 first 
                    fives -= 1;          // Give back 5
                }else
                    return false;
            }else{                              // payed 20: 2 ways to give away change
                if(tens >= 1 && fives >= 1){    // First prefer giving 10+5
                    tens -= 1;
                    fives -= 1;                  // fyi: No need to track(take) 20
                }else if(fives >= 3){
                    fives -= 3;                 // If 10+5 is not possible. Check for 5+5+5
                }else 
                    return false;               
             }
        }
        return true;                    // If you've sold for all customers, then you're out here. TRUE
    }
}
/**
Greedy
Time: O(N)
Space: O(1)
 */