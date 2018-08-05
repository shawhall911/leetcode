class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // A: 0100 0001　　C: 0100 0011　　G: 0100 0111　　T: 0101 0100
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() <= 10) return res;
        
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int mask = 0x7ffffff; // 27 1s
        int i = 0;
        int num = 0;
        while (i < 9) {
            num = (num <<= 3) | (s.charAt(i++) & 7); // Only use the right most 3 digits
        }
        
        for (i = 9; i < s.length(); i++) {
            num = ((num & mask) << 3) | (s.charAt(i) & 7);
            if (hm.containsKey(num)) {
                if (hm.get(num) == 1) res.add(s.substring(i - 9, i + 1));
            } else {
                hm.put(num, 0);
            }
            hm.put(num, hm.get(num) + 1);
        }
        
        return res;
    }
}
