class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        int min = Integer.MAX_VALUE;
        int max = -1;
        int cnt = 0;
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            if (num > 0) {
                min = Math.min(min, num);
                max = Math.max(max, num);
                if (!hs.contains(num)) {
                    cnt++;
                    hs.add(num);
                }
            }
        }
        
        if (max == -1) return 1;
        if (min > 1) return 1;
        if (max - min  + 1 == cnt) return max + 1;
        int missing = min + 1;
        while (missing < max) {
            if (!hs.contains(missing)) return missing;
            missing++;
        }
        
        return 1;
    }
}
