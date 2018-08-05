class Solution {
    public int countSubstrings(String s) {
        if(s == null ||s=="") return 0;
        int len = s.length();
        int count = 1;
        for(int i = 1; i < len; i++){
            //find the number of palindromes that ended at i
            for (int j = 0; j < i; j++){
                if(isPalin(s, j, i)) count++;
            }
            count ++; //for i
        }
        return count;
            
    }
    public boolean isPalin(String a, int i, int j){
        while(j>i) {
            if(a.charAt(i) != a.charAt(j)) return false;
            i++;j--;            
        }
        return true;
    }
    /*
    public int countSubstrings(String s) {
    int n = s.length();
    int res = 0;
    boolean[][] dp = new boolean[n][n];
    for (int i = n - 1; i >= 0; i--) {
        for (int j = i; j < n; j++) {
            dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
            if(dp[i][j]) ++res;
        }
    }
    return res;
    */
}

