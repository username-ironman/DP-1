class Solution {
    // Recursive solution
    // Time complexity is exponential and dependent on coins and amount
    // Space complexity is exponential
    // This solution gives time limit exceed on leetcode
    public int coinChange(int[] coins, int amount) {
        // edge case
        if(coins == null || coins.length == 0) return -1;
        int result = helper(coins, amount, 0, 0);
        return result;
    }
    
    // Recursive function
    public int helper(int [] coins, int reAmt, int index, int numCoins) {   
        // Base case
        if(reAmt ==0) return numCoins;
        if (index == coins.length || reAmt<0) return -1;
        //Logic
        // case1: Not choosing the coin
        int case1 = helper(coins, reAmt, index+1, numCoins);
        //case2: choosing the coin
        int case2 = helper(coins, reAmt-coins[index], index, numCoins+1);
        if (case1 == -1) return case2;
        if (case2==-1) return case1;
        return Math.min(case1,case2);
    }
}