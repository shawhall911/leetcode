class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> letters = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (!letters.containsKey(c)) letters.put(c, 0);
            letters.put(c, letters.get(c) + 1);
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!letters.containsKey(c)) return false;
            int cnt = letters.get(c);
            if (cnt == 0) return false;
            letters.put(c, cnt - 1);
        }
        
        return true;
    }
}
