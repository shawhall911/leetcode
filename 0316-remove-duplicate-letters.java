class Solution {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        buildSmallest(s, sb);
        return sb.toString();
    }
    
    private void buildSmallest(String s, StringBuilder sb) {
        if (s == null || s.length() == 0) return;
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hm.containsKey(c)) hm.put(c, 0);
            hm.put(c, hm.get(c) + 1);
        }
        
        char smallestChar = '{';
        int smallestIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < smallestChar) {
                smallestChar = c;
                smallestIndex = i;
            }
            
            int remainding = hm.get(c) - 1;
            hm.put(c, remainding);
            if (remainding == 0) break;
        }
        
        sb.append(smallestChar);
        
        if (smallestIndex < s.length() - 1)
            buildSmallest(s.substring(smallestIndex + 1).replaceAll(String.valueOf(smallestChar), ""), sb);
    }
}
