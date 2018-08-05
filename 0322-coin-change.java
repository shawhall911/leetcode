class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) dp[i] = amount + 1;
        
        for (int coin : coins)
            for (int i = coin; i <= amount; i++)
                if (dp[i - coin] <= amount) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        
        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
}
