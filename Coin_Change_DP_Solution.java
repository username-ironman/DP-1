class Solution {
    // DP solution
    // Time complexity is O(mn)
    // Space complexity is O(mn)
    // Solution is submitted on leetcode with no errors
    public int coinChange(int[] coins, int amount) {
        // Edge case
        if(coins == null || coins.length == 0)
            return -1;
        int rowLen = coins.length+1;
        int colLen = amount +1;
        int[][]dp = new int[rowLen][colLen];
        // filling infinity in the first row
        for(int j = 1; j< colLen;j++){
            dp[0][j] = amount+10;
        }
        for (int i = 1;i<rowLen;i++){
            for (int j= 0; j<colLen;j++){
                if (j< coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    int temp = dp[i][j- coins[i-1]];
                    dp[i][j] = Math.min(dp[i-1][j],temp+1);
                }
            }
        }
        int result = dp[rowLen-1][colLen-1];
        if (result>amount) return -1;
        return result;
    }
}