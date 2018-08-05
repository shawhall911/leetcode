class Solution {
    public int numSquares(int n) {
        //dp bottom up
        int[] dp = new int[n+1];
        for (int i = 0 ; i <= n ; i ++ ){
            dp[i] = i;
        }
        
        for (int i = 4 ; i <= n ; i ++)
            for (int j = 1; j <= Math.sqrt(i); j++){
                dp[i] = dp[i] < (dp[i-j*j] + 1) ? dp[i] : (dp[i-j*j] + 1);
            }
        
        return dp[n];
    }
}
//Unit-test:
//12: pass
//1: pass
//4: pass
