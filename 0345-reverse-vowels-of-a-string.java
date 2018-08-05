class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return "";
        
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        boolean flag1 = false, flag2 = false;
        while (i < j) {
            if (vowels.contains(cs[i])) flag1 = true;
            else i++;
            
            if (vowels.contains(cs[j])) flag2 = true;
            else j--;
            
            if (flag1 && flag2) {
                swap(cs, i, j);
                i++; j--;
                flag1 = false; flag2 = false;
            }
        }
        
        return new String(cs);
    }
    
    private void swap(char[] cs, int i, int j) {
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
    }
}
