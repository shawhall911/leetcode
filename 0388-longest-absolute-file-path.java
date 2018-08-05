class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 0);
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1; 
            int len = s.substring(level).length();
            if (s.indexOf(".") > 0) {
                res = Math.max(res, hm.get(level) + len);
            } else {
                hm.put(level + 1, hm.get(level) + len + 1); // "dir/" is saved as level 1
            }
        }
        
        return res;
    }
}
