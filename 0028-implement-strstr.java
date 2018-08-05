class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack==null ||needle==null) return 0;
        int i = 0; int len1 = haystack.length();
        int j = 0; int len2 = needle.length();
        
        if(len2==0 ) return 0;
        if(len2 > len1) return -1;
        
        int m = 0;
        
        for(; m <= len1-len2; m++){
            while(haystack.charAt(i) == needle.charAt(j)){
                i++;j++;
                if(j == len2) return m; //found a match
            }
            //let's move and repeat
            j = 0;
            i = m+1;
        }
        return -1;    
        
    }
}
//test cases:
//hello, ll;
//h, h;
//h, xy;
//hello, h;
//hello, o;
//hello, oy;

