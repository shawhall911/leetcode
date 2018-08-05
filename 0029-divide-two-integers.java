class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return 0 - dividend;
        }
            
        boolean negative = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0 ? false : true;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        if (m < n) return 0;
        
        long result = 0;
        while (m >= n) {
            long t = n; 
            long p = 1;
            while (m >= t) {
                t <<= 1;
                p <<= 1;
            }
            p >>= 1;
            t >>= 1;
            result += p;
            m -= t;
        }
        
        if (negative) result = 0 - result;
        return (int)result;
    }
}
