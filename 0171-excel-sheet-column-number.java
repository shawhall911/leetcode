class Solution {
    public int titleToNumber(String s) {
        
        if(s == null) return -1;
        
        int len = s.length();
        
        if(len>9) return -1;
        
        int res = 0;;
        for(int i = 0; i < len; i ++){
            char x = s.charAt(i);
            res = res*26 + (x-'A'+1);
        }
        return res;
    }
}
//test cases:
//1. null
//2. "" -->0
//3: A
//4: AB
//5: ZY, 26*26+25=701
//6: when to overflow;9 chars ok
