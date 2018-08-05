class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j ++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) dp[j][i] = true;
                if (dp[j][i] && maxLen < i - j  + 1) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
            
            dp[i][i] = true;
        }
        
        return s.substring(start, start + maxLen);
    }
}
