class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int i = 0;
        int cnt = 0;
        while (i < n) {
            if (nums[i] == val) {
                cnt++;
            } else {
                if (cnt > 0) nums[i - cnt] = nums[i];
            }
            i++;
        }
        
        return n - cnt;
    }
}
