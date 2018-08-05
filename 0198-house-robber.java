class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;
        
        if (n < 1) return 0;
        if (n < 2) return nums[0];
        if (n < 3) return nums[0] > nums[1] ? nums[0] : nums[1];
        
        int[] m = new int[n]; //the max money if we rot ith house
        
        m[0] = nums[0];
        m[1] = nums[1];
        m[2] = nums[0] + nums[2];
        
        for( int i = 0; i < n - 3; i ++){
            m[i+3] = nums[i+3] + (m[i+1] > m[i] ? m[i+1] : m[i]);
        }
        
        return m[n-1] > m[n-2] ? m[n-1] : m[n-2];
        
    }
}
