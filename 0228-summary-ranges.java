class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) return res;
        
        int start = 0;
        int i = 1;
        while (i < nums.length) {
            if ((long)nums[i] - (long)nums[i - 1] > 1) {
                appendRange(nums, start, i, res);
                start = i;
            }
            i++;
        }
        appendRange(nums, start, i, res);
        
        return res;
    }
    
    private void appendRange(int[] nums, int start, int i, List<String> res) {
        StringBuilder sb = new StringBuilder(String.valueOf(nums[start]));
        if (i - 1 > start) {
            sb.append("->");
            sb.append(nums[i - 1]);
        }
        res.add(sb.toString());
    }
}
