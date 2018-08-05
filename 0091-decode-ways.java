class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        s = "0" + s;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                else dp[i] = dp[i - 2];
            }
            else if (s.charAt(i - 1) > '2') dp[i] = dp[i - 1];
            else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) < '7') {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            else dp[i] = dp[i - 1];
        }
        
        return dp[n];
    }
}
